/***************************************************************************
 * Product 2018 by Quang Dat * 
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.exception;

import com.vtc.common.constant.ExceptionConstant;

/**
 * Creator : Le Quang Dat
 * Email   : quangdat0993@gmail.com
 * Date    : Oct 17, 2018
 */
public class ScoinDuplicateEntityException extends ScoinBusinessException {

    private static final long serialVersionUID = 7641702942202000229L;

    public ScoinDuplicateEntityException() {
        super(ExceptionConstant.DUPLICATE_ENTITY, ExceptionConstant.FAILED_TO_EXECUTE_DESCRIPTION);
    }

    public ScoinDuplicateEntityException(String message) {
        super(ExceptionConstant.DUPLICATE_ENTITY, message);
    }

    public ScoinDuplicateEntityException(String objectName, String message) {
        super(ExceptionConstant.DUPLICATE_ENTITY, objectName + ":" + message);
    }

}
