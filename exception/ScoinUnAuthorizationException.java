/***************************************************************************
 * Product 2018 by Quang Dat * 
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.exception;

import com.vtc.common.constant.ExceptionConstant;

/**
 * Creator : Le Quang Dat
 * Email   : quangdat0993@gmail.com
 * Date    : Oct 11, 2018
 */
public class ScoinUnAuthorizationException extends ScoinBusinessException{
    
    private static final long serialVersionUID = -7011622504179779499L;

    public ScoinUnAuthorizationException() {
        super(ExceptionConstant.UNAUTHORIZED, ExceptionConstant.UNAUTHORIZED_DESCRIPTION);
    }
    
    public ScoinUnAuthorizationException(String message) {
        super(ExceptionConstant.UNAUTHORIZED, message);
    }
    
    public ScoinUnAuthorizationException(String objectName, String message) {
        super(ExceptionConstant.UNAUTHORIZED, objectName + " : " + message);
    }

}
