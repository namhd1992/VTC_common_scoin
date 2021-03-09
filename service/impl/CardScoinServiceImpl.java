/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.service.impl;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.vtc.common.constant.Constant;
import com.vtc.common.dto.request.ScoinCardXMLRequest;
import com.vtc.common.dto.request.TopupCardUserHistoryGet;
import com.vtc.common.dto.response.BuyCardScoinResponse;
import com.vtc.common.dto.response.GetCardScoinResponse;
import com.vtc.gateway.scoinv2api.common.EnvironmentKey;
import com.vtc.gateway.scoinv2api.common.dao.entity.FundsCardScoin;
import com.vtc.gateway.scoinv2api.common.dao.entity.LuckySpinSetting;
import com.vtc.gateway.scoinv2api.common.dao.entity.TopupCardHistory;
import com.vtc.gateway.scoinv2api.common.dao.entity.UserInfo;
import com.vtc.gateway.scoinv2api.common.dao.repository.FundsCardScoinRepository;
import com.vtc.gateway.scoinv2api.common.dao.repository.LuckySpinSettingRepository;
import com.vtc.gateway.scoinv2api.common.dao.repository.TopupCardHistoryRepository;
import com.vtc.gateway.scoinv2api.common.exception.ScoinBusinessException;
import com.vtc.gateway.scoinv2api.common.exception.ScoinFailedToExecuteException;
import com.vtc.gateway.scoinv2api.common.exception.ScoinInvalidDataRequestException;
import com.vtc.gateway.scoinv2api.common.exception.ScoinUnAuthorizationException;
import com.vtc.gateway.scoinv2api.common.service.AbstractService;
import com.vtc.gateway.scoinv2api.common.service.CardScoinService;
import com.vtc.gateway.scoinv2api.common.utils.ApiExchangeServiceUtil;
import com.vtc.gateway.scoinv2api.common.utils.DateUtils;
import com.vtc.gateway.scoinv2api.common.utils.EncryptAndDecryptUtils;
import com.vtc.gateway.scoinv2api.common.utils.StringUtils;
import com.vtc.gateway.scoinv2api.userInfo.service.UserInfoService;

/**
 * Author : Dat Le Quang
 * Email: Quan

import org.springframework.stereotype.Service;gdat0993@gmail.com
 * Jul 9, 2019
 */
@Service("cardScoinService")
public class CardScoinServiceImpl extends
        AbstractService<FundsCardScoin, Long, FundsCardScoinRepository> implements CardScoinService {
    
    @Autowired
    TopupCardHistoryRepository topupCardHistoryRepo;
    
    @Autowired
    UserInfoService userInfoService;
    
    @Autowired
    LuckySpinSettingRepository luckySpinSettingRepo;
    
    private String CARD_API_URL;
    private String CARD_API_KEY_DECODE_TRIPLEDES;
    
    public CardScoinServiceImpl(Environment env) {
        CARD_API_URL = env.getProperty(EnvironmentKey.LIVE_FUND_REQUEST_CARD_API_URL.getKey());
        CARD_API_KEY_DECODE_TRIPLEDES = env
                .getProperty(EnvironmentKey.LIVE_CARD_API_KEY_DECODE_TRIPLEDES.getKey());
    }

    @Override
    public FundsCardScoin buyCard(String valueCard, Integer quantityCard) throws ScoinBusinessException {
        
        //Create requestData in request call api to scoin
        String urlprivatekey = Constant.PROJECT_RESOURCES + Constant.FILE_PRIVATE_KEY_SCOIN_CARD;
        String transDate = DateUtils.toStringFormDate(new Date(), DateUtils.DATE_TIME_CODE_SCOIN);
        
        String partnerCode = Constant.SCOIN_CARD_PARTNER_CODE;
        String serviceCode = Constant.SCOIN_CARD_SERVICE_CODE_SCOIN;
        String amount = valueCard;
        String quantity = quantityCard.toString();
        Random rand = new Random();
        int  n = rand.nextInt(50) + 1;
        String orgTransID = transDate + n;
        String DataSign = CreateSignRSAFileKeyPartner("" + serviceCode + 
                                                      "-" + amount + 
                                                      "-" + quantity + 
                                                      "-" + partnerCode + 
                                                      "-" + transDate + 
                                                      "-" + orgTransID, 
                                                      urlprivatekey);
        String requestData = createRequestDataBuyCard(serviceCode, amount, quantity, transDate, orgTransID, DataSign);
        
        //Create request of call api to Scoin 
        ScoinCardXMLRequest scoinCardXMLRequest = new ScoinCardXMLRequest();
        scoinCardXMLRequest.setRequesData(requestData);
        scoinCardXMLRequest.setPartnerCode(partnerCode);
        scoinCardXMLRequest.setCommandType(Constant.SCOIN_CARD_COMMAND_TYPE_BUYCARD);
        scoinCardXMLRequest.setVersion(Constant.SCOIN_CARD_VERSION);
        String requestCallApiBuyCard = createRequestScoinCardXML(scoinCardXMLRequest);
        
        //Call api buy card of Scoin
        String dataResponse = ApiExchangeServiceUtil.postXML(CARD_API_URL, 
                requestCallApiBuyCard);
        
        // convert string xml response to object
        String textStartResponse = Constant.SCOIN_CARD_TEXT_START_RESPONSE;
        int startIndex = dataResponse.indexOf(textStartResponse) + textStartResponse.length();
        int endIndex = dataResponse.indexOf(textStartResponse.replace("<", "</"));
        
        // Định dạng response : <ResponseCode>|<OrgTransID>|<VTCTransID>|<PartnerBalance>|<DataSign>
        String[] responseStrings = dataResponse.substring(startIndex, endIndex).split("[|]");
        if(!responseStrings[0].equals("1")) {
            throw new ScoinFailedToExecuteException("Call to api BUYCARD Scoin Unsuccess with repose code : " + responseStrings[0]);
        }
        
        // Convert Object from string xml response
        BuyCardScoinResponse response = new BuyCardScoinResponse();
        response.setResponseCode(responseStrings[0]);
        response.setOrgTransId(responseStrings[1]);
        response.setVTCTransId(responseStrings[2]);
        response.setPartnerBalance(responseStrings[3]);
        response.setDataSign(responseStrings[4]);
        
        GetCardScoinResponse cardScoin = getCard(amount, response.getVTCTransId());
        
        // Save FundsCardScoin
        FundsCardScoin fundsCardScoin = new FundsCardScoin();
        fundsCardScoin.setFundsAccount(partnerCode);
        fundsCardScoin.setFundsBalance(Long.parseLong(response.getPartnerBalance()));
        fundsCardScoin.setOrgTransID(response.getOrgTransId());
        fundsCardScoin.setVtcTransID(response.getVTCTransId());
        fundsCardScoin.setDataSign(response.getDataSign());
        fundsCardScoin.setMainCodeCard(cardScoin.getMainCode());
        fundsCardScoin.setSeriCard(cardScoin.getSeri());
        fundsCardScoin.setExpirationDateCard(cardScoin.getExpirationDate());
        fundsCardScoin.setValueCard(Integer.parseInt(amount));
        fundsCardScoin.setStatus(Constant.STATUS_SUCCESS);
        fundsCardScoin = repo.save(fundsCardScoin);
        
        return fundsCardScoin;
    }
    
    @Override
    public GetCardScoinResponse getCard(String valueCard, String VTCTranID) throws ScoinBusinessException {
        String partnerCode = Constant.SCOIN_CARD_PARTNER_CODE;
        String serviceCode = Constant.SCOIN_CARD_SERVICE_CODE_SCOIN;
        String amount = valueCard;
        
        String dataSign = CreateSignRSAFileKeyPartner(serviceCode + 
                                            "-" + amount + 
                                            "-" + partnerCode + 
                                            "-" + VTCTranID,
                Constant.PROJECT_RESOURCES + Constant.FILE_PRIVATE_KEY_SCOIN_CARD);
        String requestData = createRequestDataGetCard(serviceCode, amount, VTCTranID, dataSign);
        
        ScoinCardXMLRequest scoinCardXMLRequest = new ScoinCardXMLRequest();
        scoinCardXMLRequest.setRequesData(requestData);
        scoinCardXMLRequest.setPartnerCode(partnerCode);
        scoinCardXMLRequest.setCommandType(Constant.SCOIN_CARD_COMMAND_TYPE_GETCARD);
        scoinCardXMLRequest.setVersion(Constant.SCOIN_CARD_VERSION);
        String resquestCallApiXML = createRequestScoinCardXML(scoinCardXMLRequest);
        String dataResponse = ApiExchangeServiceUtil.postXML(CARD_API_URL, 
                                                 resquestCallApiXML);
        // convert string xml response to object
        String textStartResponse = Constant.SCOIN_CARD_TEXT_START_RESPONSE;
        int startIndex = dataResponse.indexOf(textStartResponse) + textStartResponse.length();
        int endIndex = dataResponse.indexOf(textStartResponse.replace("<", "</"));
        String responseString = dataResponse.substring(startIndex, endIndex);
        String response = null;
        try {
            //Decrypt response tripleDES
            response = EncryptAndDecryptUtils.tripleDESDecrypt(CARD_API_KEY_DECODE_TRIPLEDES,responseString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Đinh dạng response : <ResponseCode>|<OrgTranID|<ListCard>
        String[] responseStrings = response.split("[|]");
        
        if(!responseStrings[0].equals("1")) {
            throw new ScoinFailedToExecuteException("Call to api GETCARD Scoin Unsuccess with repose code : " + responseStrings[0]);
        }
        
        // <ListCard> = <CardCode1>:<CardSerial1>:<ExpriceDate1>|<CardCoden>:<CardSerialn>:<ExpriceDaten>
        //Convert response to Object
        String [] listCardProperties = responseStrings[2].split("[:]");
        GetCardScoinResponse getCardScoinResponse = new GetCardScoinResponse();
        getCardScoinResponse.setMainCode(listCardProperties[0]);
        getCardScoinResponse.setSeri(listCardProperties[1]);
        getCardScoinResponse.setExpirationDate(DateUtils.toDateFromStr(listCardProperties[2], DateUtils.DATE_DEFAULT_FORMAT));
        
        return getCardScoinResponse;
    }
    
    @Override
    public String saveTopupCardUserHistory(TopupCardUserHistoryGet request) {
        if (ObjectUtils.isEmpty(request)
                || ObjectUtils.isEmpty(request.getScoinId())
                || StringUtils.isEmpty(request.getCardType())
                || request.getCardValue() < 1
                || request.getScoinTransId() < 1
                || request.getServiceId() < 1
                || StringUtils.isEmpty(request.getSign())) {
            throw new ScoinInvalidDataRequestException();
        }
        
        String keyPushTopUpCardHisScoin = StringUtils.toMD5(Constant.SCOIN_CARD_TOPUP_HISTORY);
        String dataSign = StringUtils.toMD5(keyPushTopUpCardHisScoin 
                    + request.getScoinId().toString()
                    + String.valueOf(request.getScoinTransId())
                    + String.valueOf(request.getCardValue()));
        if (!request.getSign().equals(dataSign)) {
            throw new ScoinUnAuthorizationException("Only the scoin can call this api");
        }
        
        TopupCardHistory historyByTransId = topupCardHistoryRepo.findByScoinTransId(request.getScoinTransId());
        if (!ObjectUtils.isEmpty(historyByTransId)) return "Empty topup history";
        
        UserInfo userInfo = userInfoService.getByScoinId(request.getScoinId());
        
        TopupCardHistory topupCardHistory = new TopupCardHistory();
        topupCardHistory.setScoinId(request.getScoinId());
        if (!ObjectUtils.isEmpty(userInfo)) topupCardHistory.setUserInfo(userInfo);
        topupCardHistory.setCardType(request.getCardType());
        topupCardHistory.setCardValue(request.getCardValue());
        topupCardHistory.setScoinTransId(request.getScoinTransId());
        if(!ObjectUtils.isEmpty(request.getServiceId())) topupCardHistory.setServiceId(request.getServiceId());
        topupCardHistory.setLuckyWheelUsed(false);
        topupCardHistory = topupCardHistoryRepo.save(topupCardHistory);
        
        //update doanh thu cho lucky_spin
        Date startDate = DateUtils.toDateFromStr("2019-07-29 00:00:00" , DateUtils.DATE_TIME_MYSQL_FORMAT);
        List<TopupCardHistory> topupCardByDates = topupCardHistoryRepo.findByCreateOnAfter(startDate);
        long totalTurnover = 0;
        if (!CollectionUtils.isEmpty(topupCardByDates)) {
            for (TopupCardHistory topupCardByDate : topupCardByDates) {
                totalTurnover += topupCardByDate.getCardValue();
            }
        }
        
        LuckySpinSetting luckySpinSetting = new LuckySpinSetting();
        luckySpinSetting = luckySpinSettingRepo.
                findByKeyNameAndStatus(Constant.LUCKYSPIN_KEYNAME_TOTAL_TURNOVER, Constant.STATUS_ACTIVE);
        if (ObjectUtils.isEmpty(luckySpinSetting)) {
            luckySpinSetting = new LuckySpinSetting();
            luckySpinSetting.setName("Total Turnover");
            luckySpinSetting.setKeyName(Constant.LUCKYSPIN_KEYNAME_TOTAL_TURNOVER);
            luckySpinSetting.setStatus(Constant.STATUS_ACTIVE);
            luckySpinSetting.setType("luckyspin_turnover");
        }
        
        luckySpinSetting.setIntValue(totalTurnover);
        luckySpinSettingRepo.save(luckySpinSetting);
        
        return "Successful";
    }

    
    
//=================================COMPONENT======================================
    
    private static  String createRequestDataBuyCard(String ServiceCode,String Amount,String Quantity,String TransDate,String OrgTransID,String DataSign){
        String xmlre=  "&lt;?xml version=\"1.0\" encoding=\"utf-16\"?&gt;\n" +
                       "&lt;RequestData xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"&gt;\n" +
                       "  &lt;ServiceCode&gt;"+ServiceCode+"&lt;/ServiceCode&gt;\n" +
                       "  &lt;Amount&gt;"+Amount+"&lt;/Amount&gt;\n" +
                       "  &lt;Quantity&gt;"+Quantity+"&lt;/Quantity&gt;\n" +
                       "  &lt;TransDate&gt;"+TransDate+"&lt;/TransDate&gt;\n" +
                       "  &lt;OrgTransID&gt;"+OrgTransID+"&lt;/OrgTransID&gt;\n" +
                       "  &lt;DataSign&gt;"+DataSign+"&lt;/DataSign&gt;\n" +
                       "&lt;/RequestData&gt;";
           return xmlre;
    }
    
    public static  String createRequestDataGetCard(String ServiceCode, String Amount,String OrgTransID,String DataSign){
        try { 
        String xmlre=  "&lt;?xml version=\"1.0\" encoding=\"utf-16\"?&gt;\n" +
                       "&lt;RequestData xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"&gt;\n" +
                       "  &lt;ServiceCode&gt;"+ServiceCode+"&lt;/ServiceCode&gt;\n" +
                       "  &lt;Amount&gt;"+Amount+"&lt;/Amount&gt;\n" +
                       "  &lt;OrgTransID&gt;"+OrgTransID+"&lt;/OrgTransID&gt;\n" +
                       "  &lt;DataSign&gt;"+DataSign+"&lt;/DataSign&gt;\n" +
                       "&lt;/RequestData&gt;";
           return xmlre;
       } catch (Exception ex) {
           return  ex.toString();
       }
    }
      
      private String createRequestScoinCardXML(ScoinCardXMLRequest request) {
          return "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><RequestTransaction xmlns=\"http://tempuri.org/\"><requesData>" 
                      + request.getRequesData()
                      + "</requesData><partnerCode>" + request.getPartnerCode()
                      + "</partnerCode><commandType>" + request.getCommandType()
                      + "</commandType><version>" + request.getVersion()
                      + "</version></RequestTransaction></soap:Body></soap:Envelope>";
      }
    
    @SuppressWarnings("cast")
    public static String CreateSignRSAFileKeyPartner(String data, String filePath) {
        try {
            final File privKeyFile = new File(filePath);
            final byte[] privKeyBytes = readFile(privKeyFile);
            final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            final PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(privKeyBytes);
            final PrivateKey pk = (PrivateKey) keyFactory.generatePrivate(privSpec);

            final Signature sg = Signature.getInstance("SHA1withRSA");

            sg.initSign(pk);
            sg.update(data.getBytes());
            final byte[] bDS = sg.sign();
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(bDS));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
    
    public static byte[] readFile(final File file)
            throws FileNotFoundException, IOException {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream(file));
            final byte[] data = new byte[dis.available()];
            dis.readFully(data);
            dis.close();
            return data;
        } finally {
            if (dis != null) {
                dis.close();
            }
        }
    }

}
