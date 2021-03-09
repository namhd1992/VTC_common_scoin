/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.exception;

import com.vtc.common.constant.ExceptionConstant;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Oct 14, 2018
 */
public class ScoinFailedToExecuteException extends ScoinBusinessException {
    
    private static final long serialVersionUID = 7641702942202000228L;

    public ScoinFailedToExecuteException() {
        super(ExceptionConstant.FAILED_TO_EXECUTE, ExceptionConstant.FAILED_TO_EXECUTE_DESCRIPTION);
    }
    
    public ScoinFailedToExecuteException(String message) {
        super(ExceptionConstant.FAILED_TO_EXECUTE, message);
    }

    public ScoinFailedToExecuteException(String objectName, String message) {
        super(ExceptionConstant.FAILED_TO_EXECUTE, objectName + ":" + message);
    }

}
