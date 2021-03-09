/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.constant;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Apr 22, 2019
 */
public class ExceptionConstant {
    
    public static final String UNKNOWN_ERROR                     = "00";
    public static final String UNKNOWN_ERROR_DESCRIPTION         = "Unknown Error";

    public static final String SUCCESS                           = "01";
    public static final String SUCCESS_DESCRIPTION               = "Successful!";

    public static final String INVALID_DATA_REQUEST              = "02";
    public static final String INVALID_DATA_REQUEST_DESCRIPTION  = "Invalid Input's request!";
    
    public static final String NOT_FOUND_ENTITY                  = "03";
    public static final String NOT_FOUND_ENTITY_DESCRIPTION      = "Not found entity!";

    public static final String DUPLICATE_ENTITY                  = "04";
    public static final String DUPLICATE_ENTITY_DESCRIPTION      = "Duplicate Entity!";
    
    public static final String NOT_ENOUGHT                       = "05";
    public static final String NOT_ENOUGHT_DESCRIPTION           = "You don't enought!";

    public static final String UNAUTHORIZED                      = "06";
    public static final String UNAUTHORIZED_DESCRIPTION          = "No permission to do!";
    
    public static final String TIMING_START_AND_END              = "07";
    public static final String TIMING_START_AND_END_DESCRIPTION  = "Has not taken place or has ended";

    public static final String FAILED_TO_EXECUTE                 = "08";
    public static final String FAILED_TO_EXECUTE_DESCRIPTION     = "Failed to execute!";

    public static final String EXPIRED_SESSION                   = "09";
    public static final String EXPIRED_SESSION_DESCRIPTION       = "The session has expired!";
    
//    ============================ CALL TO SCOIN ===================================================
    
    public static final int    STATUS_CODE_SUCCESSFUL_XU         = 1;
    
    public static final String NOT_ENOUGH_BALANCE_XU              = "-55";
    public static final String NOT_ENOUGH_BALANCE_XU_DESCRIPTION  = "Số dư XU không đủ";

}
