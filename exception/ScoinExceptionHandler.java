/***************************************************************************
 * Product 2018 by Quang Dat * 
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vtc.gateway.scoinv2api.common.dto.response.ScoinResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * Creator : Le Quang Dat
 * Email   : quangdat0993@gmail.com
 * Date    : Oct 11, 2018
 */
@ControllerAdvice
@Slf4j
public class ScoinExceptionHandler extends ResponseEntityExceptionHandler {
  
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinBusinessException.class)
    public ResponseEntity<ScoinResponse<String>> handleSplayBusinessException(final HttpServletRequest request,
                                                                              final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<String> response = new ScoinResponse<String>();
        response.setStatus(((ScoinBusinessException) e).getStatus());
        response.setMessage(e.getMessage());
        return new ResponseEntity<ScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinInvalidDataRequestException.class)
    public ResponseEntity<ScoinResponse<String>> handleInvalidInputException(final HttpServletRequest request,
                                                                             final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<String> response = new ScoinResponse<String>();
        response.setStatus(((ScoinInvalidDataRequestException) e).getStatus());
        response.setMessage(e.getMessage());
        return new ResponseEntity<ScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinNotFoundEntityException.class)
    public ResponseEntity<ScoinResponse<String>> handleNotFoundException(final HttpServletRequest request,
                                                                         final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<String> response = new ScoinResponse<String>();
        response.setStatus(((ScoinNotFoundEntityException) e).getStatus());
        response.setMessage(e.getMessage());
        return new ResponseEntity<ScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinUnAuthorizationException.class)
    public ResponseEntity<ScoinResponse<String>> handleUnauthorizedException(final HttpServletRequest request,
                                                                             final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<String> response = new ScoinResponse<String>();
        response.setStatus(((ScoinUnAuthorizationException) e).getStatus());
        response.setMessage(e.getMessage());
        return new ResponseEntity<ScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinFailedToExecuteException.class)
    public ResponseEntity<ScoinResponse<String>> handleBluuFailedToExecuteException(final HttpServletRequest request,
                                                                     final Exception e) {
        log.info(e.getMessage(),e);
        ScoinResponse<String> response = new ScoinResponse<String>();
        response.setStatus(((ScoinFailedToExecuteException)e).getStatus());
        response.setMessage(e.getMessage());
        return new ResponseEntity<ScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinDuplicateEntityException.class)
    public ResponseEntity<ScoinResponse<String>> handleDuplicateEntityException(final HttpServletRequest request,
                                                                                final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<String> response = new ScoinResponse<String>();
        response.setStatus(((ScoinDuplicateEntityException) e).getStatus());
        response.setMessage(e.getMessage());
        return new ResponseEntity<ScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinNotEnoughtException.class)
    public ResponseEntity<ScoinResponse<String>> handleNotEnoughtException(final HttpServletRequest request,
                                                                           final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<String> response = new ScoinResponse<String>();
        response.setStatus(((ScoinNotEnoughtException) e).getStatus());
        response.setMessage(e.getMessage());
        return new ResponseEntity<ScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinUnknownErrorException.class)
    public ResponseEntity<ScoinResponse<String>> handleUnknownErrorException(final HttpServletRequest request,
                                                                             final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<String> response = new ScoinResponse<String>();
        response.setStatus(((ScoinUnknownErrorException) e).getStatus());
        response.setMessage(e.getMessage());
        return new ResponseEntity<ScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinTimingStartAndEndException.class)
    public ResponseEntity<ScoinResponse<String>> handleTimingStartAndEndException(final HttpServletRequest request,
                                                                             final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<String> response = new ScoinResponse<String>();
        response.setStatus(((ScoinTimingStartAndEndException) e).getStatus());
        response.setMessage(e.getMessage());
        return new ResponseEntity<ScoinResponse<String>>(response, null, HttpStatus.OK);
    }

}
