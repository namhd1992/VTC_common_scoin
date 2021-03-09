/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.utils;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Apr 24, 2019
 */
public class JsonMapperUtils {
    
    private static ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonMapperUtils.class);

    public static <O> String toJson(O o) {
        try {
            return "\n" + mapper.writeValueAsString(o) + "\n";
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return e.getMessage();
        }
    }

    public static <T> T convertJsonToObject(String jsonStr, final Class<T> clazz) {
        try {
            return mapper.readValue(jsonStr, clazz);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    public static <T> T convertJsonToObject(String jsonStr, final TypeReference<T> reference) {
        try {
            return mapper.readValue(jsonStr, reference);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }
    
    public static <T> T readJsonFileToObject(String urlFile, final TypeReference<T> reference) {
        File jsonFile = new File(urlFile);
        if (!jsonFile.exists()) {
            return null;
        }
        
        try {
            return mapper.readValue(jsonFile, reference);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }
    
    public static <T> T writeObjectToJsonFile(String urlFile, T content) {
        File jsonFile = new File(urlFile);
//        if (!jsonFile.exists()) {
//            jsonFile.mkdir();
//        }
        
        try {
            mapper.writeValue(jsonFile, content);
            return content;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }
    
}
