/***************************************************************************
 * Product 2018 by Quang Dat * 
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Creator : Le Quang Dat
 * Email   : quangdat0993@gmail.com
 * Date    : Oct 30, 2018
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScoinLoginServiceHistoryResponse {

    private Long   AccountId;

    private String AccountName;

    private Long   ServiceId;

    private Long   AgencyId;

    private Date   FirstLogin;

    private Date   LastLogin;

}
