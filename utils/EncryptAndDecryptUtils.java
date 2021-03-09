/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 11, 2019
 */
public class EncryptAndDecryptUtils {
    
    public static String tripleDESEncrypt(String key,String data) throws Exception
    {
        Cipher cipher=Cipher.getInstance("TripleDES");
        MessageDigest md5=MessageDigest.getInstance("MD5");
        md5.update(key.getBytes(),0,key.length());
        String keymd5 = new
        BigInteger(1,md5.digest()).toString(16).substring(0,24); 
        SecretKeySpec keyspec = new SecretKeySpec(keymd5.getBytes(),"TripleDES");
        cipher.init(Cipher.ENCRYPT_MODE,keyspec);
        byte[] stringBytes=data.getBytes();
        byte[] raw=cipher.doFinal(stringBytes);
        String base64 = Base64.getEncoder().encodeToString(raw);
        return base64;
    }
    
    
    public static String tripleDESDecrypt(String key,String data) throws Exception
    {
        Cipher cipher=Cipher.getInstance("TripleDES");
        MessageDigest
        md5=MessageDigest.getInstance("MD5");
        md5.update(key.getBytes(),0,key.length());
        String keymd5 = new
        BigInteger(1,md5.digest()).toString(16).substring(0,24); 
        SecretKeySpec keyspec = new SecretKeySpec(keymd5.getBytes(),"TripleDES");
        cipher.init(Cipher.DECRYPT_MODE,keyspec);
        byte[] raw = Base64.getDecoder().decode(data);
        byte[] stringBytes = cipher.doFinal(raw);
        String result = new String(stringBytes);
        return result;
    }
  
}
