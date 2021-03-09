/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.exception;

import com.vtc.common.constant.ExceptionConstant;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Nov 20, 2018
 */
public class ScoinUnknownErrorException extends ScoinBusinessException {
    
    private static final long serialVersionUID = -1354707523557446934L;

    public ScoinUnknownErrorException() {
        super(ExceptionConstant.UNKNOWN_ERROR, ExceptionConstant.UNKNOWN_ERROR_DESCRIPTION);
    }

    public ScoinUnknownErrorException(String message) {
        super(ExceptionConstant.UNKNOWN_ERROR, message);
    }
    
    public ScoinUnknownErrorException(String status, String message) {
        super(status, message);
    }

//    public UnknownErrorException(String objectName, String message) {
//        super(StatusCode.UNKNOWN_ERROR, objectName + ":" + message);
//    }

}
