/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtc.common.constant.ExceptionConstant;
import com.vtc.common.dto.response.ScoinResponse;
import com.vtc.gateway.scoinv2api.common.utils.JsonMapperUtils;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Apr 18, 2019
 */
public class AbstractController<S> {
    
    @Autowired
    protected ObjectMapper json;
    
    protected Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    protected S      service;
    
    public <T> ScoinResponse<T> toResult(T t) {
        var response = new ScoinResponse<T>();
        response.setStatus("01");
        response.setMessage("Successful");
        response.setData(t);
        response.setTotalRecords(0);
        LOGGER.info("===============RESPONSE============== \n {}", 
                JsonMapperUtils.toJson(response));
        return response;
    }
    
    public <T> ScoinResponse<T> toResult(T t, int totalRecords) {
        var response = new ScoinResponse<T>();
        response.setStatus("01");
        response.setMessage("Successful");
        response.setData(t);
        response.setTotalRecords(totalRecords);
        LOGGER.info("===============RESPONSE============== \n {}", 
                JsonMapperUtils.toJson(response));
        return response;
    }
    
    /**
     * Create response
     *
     * @param response
     * @return response
     */
    protected <T> ResponseEntity<ScoinResponse<T>> response(ScoinResponse<T> response) {
        if (response == null) {
            throw new IllegalArgumentException("Please set responseBean.");
        }

        if (StringUtils.isEmpty(response.getStatus())) {
            response.setStatus(ExceptionConstant.SUCCESS);
        }
        return new ResponseEntity<ScoinResponse<T>>(response, HttpStatus.OK);
    }
    
}
