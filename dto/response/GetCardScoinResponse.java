/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 11, 2019
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetCardScoinResponse {

    private String mainCode;

    private String seri;

    private Date   expirationDate;

}
