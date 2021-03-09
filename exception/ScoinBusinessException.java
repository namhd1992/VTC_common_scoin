/***************************************************************************
 * Product 2018 by Quang Dat * 
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Creator : Le Quang Dat
 * Email   : quangdat0993@gmail.com
 * Date    : Oct 11, 2018
 */
@Setter
@Getter
@NoArgsConstructor
public class ScoinBusinessException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    protected String status;
    
    protected Object data;

    public ScoinBusinessException(String status) {
        super();
        this.status = status;
    }
    
    public ScoinBusinessException(String status,String message) {
        super(message);
        this.status = status;
    }
    
    public ScoinBusinessException(String status, Object data, String message) {
        super(data + ": " + message);
        this.status = status;
    }

}
