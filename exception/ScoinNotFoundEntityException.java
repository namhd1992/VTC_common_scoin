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
public class ScoinNotFoundEntityException extends ScoinBusinessException{
    
    private static final long serialVersionUID = -3250565306799084671L;

    public ScoinNotFoundEntityException() {
        super(ExceptionConstant.NOT_FOUND_ENTITY, ExceptionConstant.NOT_FOUND_ENTITY_DESCRIPTION);
    }
    
    public ScoinNotFoundEntityException(String message) {
        super(ExceptionConstant.NOT_FOUND_ENTITY, message);
    }
    
    public ScoinNotFoundEntityException(String objectName, String message) {
        super(ExceptionConstant.NOT_FOUND_ENTITY, objectName + " : " + message);
    }

}
