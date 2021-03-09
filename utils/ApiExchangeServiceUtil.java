/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.utils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.vtc.gateway.scoinv2api.common.exception.ScoinUnknownErrorException;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 14, 2019
 */
public class ApiExchangeServiceUtil {
    
    private static Logger LOGGER = LoggerFactory.getLogger(ApiExchangeServiceUtil.class);

    public static <R> R get(String url, TypeReference<R> refe) {
//        LOGGER.info("URL GET CALL TO SERVER **** : {}", JsonMapperUtils.toJson(url));
        ResponseEntity<String> responseEntity = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        } catch (HttpClientErrorException e) {
            LOGGER.info("" + e.getStatusCode());
            LOGGER.info("" + e.getResponseBodyAsString());
            throw new ScoinUnknownErrorException("99", "CallToOtherServerUtils Falue");
        }
//        LOGGER.info("RESPONSE GET CALL TO SERVER **** : {}", JsonMapperUtils.toJson(responseEntity.getBody()));
        return JsonMapperUtils.convertJsonToObject(responseEntity.getBody(), refe);
    }
    
    public static <R,T> R post(String url, T resquet, TypeReference<R> refe) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        
        HttpEntity<T> reqBody = new HttpEntity<>(resquet, headers);
//        LOGGER.info("REQUEST BODY POST CALL TO SERVER **** : {}", JsonMapperUtils.toJson("URL : " + url + ", " 
//                            + JsonMapperUtils.toJson(reqBody)));
        
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters()
        .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        
        ResponseEntity<String> responseEntity = null;
        try {
          responseEntity = restTemplate.exchange(url, HttpMethod.POST, reqBody, String.class);
        } catch (HttpClientErrorException e) {
            LOGGER.info("" + e.getStatusCode());
            LOGGER.info("" + e.getResponseBodyAsString());
            throw new ScoinUnknownErrorException("99", "CallToOtherServerUtils Falue");
        }
        
//        LOGGER.info("RESPONSE GET CALL TO SERVER **** : {}", JsonMapperUtils.toJson(responseEntity.getBody()));
        return JsonMapperUtils.convertJsonToObject(responseEntity.getBody(), refe);
    }
    
    public static <R,T> R postURLENCODE(String url, T resquet, TypeReference<R> refe) {
      HttpHeaders headers = new HttpHeaders();
      headers.add("Accept", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
      HttpEntity<T> reqBody = new HttpEntity<>(resquet, headers);
      LOGGER.info("REQUEST BODY POST CALL TO SERVER **** : {}", JsonMapperUtils.toJson("URL : " + url + ", " +reqBody));
      
      RestTemplate restTemplate = new RestTemplate();
      restTemplate.getMessageConverters()
      .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
      
      ResponseEntity<String> responseEntity = null;
      try {
        responseEntity = restTemplate.exchange(url, HttpMethod.POST, reqBody, String.class);
      } catch (HttpClientErrorException e) {
          LOGGER.info("" + e.getStatusCode());
          LOGGER.info("" + e.getResponseBodyAsString());
          throw new ScoinUnknownErrorException("99", "CallToOtherServerUtils Falue");
      }
      
//      LOGGER.info("RESPONSE GET CALL TO SERVER **** : {}", JsonMapperUtils.toJson(responseEntity.getBody()));
      return JsonMapperUtils.convertJsonToObject(responseEntity.getBody(), refe);
  }
    
    public static <R,T> String postXML(String url, T resquet) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_XML);
        
        HttpEntity<T> reqBody = new HttpEntity<>(resquet, headers);
        LOGGER.info("REQUEST BODY POST CALL TO SERVER **** : {}", 
                JsonMapperUtils.toJson("URL : " + url + ", REQUEST BODY : " +reqBody));
        
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new StringHttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);
        
        ResponseEntity<String> responseEntity = null;
        try {
          responseEntity = restTemplate.postForEntity(url, reqBody, String.class);
        } catch (HttpClientErrorException e) {
            LOGGER.info("" + e.getStatusCode());
            LOGGER.info("" + e.getResponseBodyAsString());
            throw new ScoinUnknownErrorException("99", "CallToOtherServerUtils Falue");
        }
        
        LOGGER.info("RESPONSE GET CALL TO SERVER **** : {}", JsonMapperUtils.toJson(responseEntity.getBody()));
        return responseEntity.getBody();
    }

}
