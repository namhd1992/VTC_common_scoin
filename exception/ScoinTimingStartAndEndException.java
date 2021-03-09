/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.exception;

import com.vtc.common.constant.ExceptionConstant;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 30, 2019
 */
public class ScoinTimingStartAndEndException extends ScoinBusinessException {

    private static final long serialVersionUID = 1L;

    public ScoinTimingStartAndEndException() {
        super(ExceptionConstant.TIMING_START_AND_END,
                ExceptionConstant.TIMING_START_AND_END_DESCRIPTION);
    }

    public ScoinTimingStartAndEndException(String message) {
        super(ExceptionConstant.TIMING_START_AND_END, message);
    }

    public ScoinTimingStartAndEndException(String objectName, String message) {
        super(ExceptionConstant.TIMING_START_AND_END, objectName + " : " + message);
    }

}
