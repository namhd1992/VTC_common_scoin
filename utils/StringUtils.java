/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Nov 14, 2018
 */
public class StringUtils extends org.springframework.util.StringUtils {
    
    public static String toMD5(String string) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(string.getBytes());

            byte byteData[] = md.digest();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++)
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String hiddenCharString(String string, int numCharHidden) {
        int numView = string.length() - numCharHidden;
        String encode = "";
        for (int i = 0 ; i < numCharHidden ; i ++ ) {
            encode = encode + "*";
        }
        
        return string.substring(0, numView) + encode;
    }
    
    public static String encodeEmail(String string) {
        StringBuilder mail = new StringBuilder(string);
        int lastChar = mail.indexOf("@") - 1;
        for (int i = 1 ; i < lastChar ; i ++ ) {
            mail.setCharAt(i, '*');
        }
        
        return mail.toString();
    }
    
    public static String generateRamdomCode(int numberChar, String signOfCode) {
        int charMin = 48; // letter '0'
        int charMax = 90; // letter 'Z'
        int targetStringLength = numberChar;
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = ThreadLocalRandom.current().nextInt(charMin, charMax);
            // bỏ các ký tự đặc biệt
            while (randomLimitedInt > 57 && randomLimitedInt < 65) {
                randomLimitedInt = ThreadLocalRandom.current().nextInt(charMin, charMax);
            }
            buffer.append((char) randomLimitedInt);
        }
        return signOfCode + buffer.toString();
    }
    
    public static int generateBonusNumber(int digitNumber, int lastNumber) {
        String maxBonusNumberString = "";
        for (int i = 0; i < digitNumber; i++) {
            maxBonusNumberString += "9";
        }
        
        int numberResponse = 0;
        int dem = 0;
        Integer maxBonusNumber = Integer.parseInt(maxBonusNumberString);
        for (Integer i = lastNumber + 1; i < maxBonusNumber + 1; i++) {
            boolean flag1 = true;
            String so = i.toString();
            for (int j = 0; j < so.length(); j++) {
                boolean flag2 = true;
                for (int k = 1; k < so.length(); k++) {
                    if (j != k && Character.toString(so.charAt(j))
                            .equals(Character.toString(so.charAt(k)))) {
                        flag2 = false;
                        numberResponse = lastNumber + dem;
                        break;
                    }
                }
                if (flag2 == false) {
                    flag1 = false;
                    break;
                }
            }
            if (flag1 == true) {
                numberResponse = lastNumber + dem;
                return numberResponse;
            }
            dem++;
        }
        
        return 0;
    }
    
}
