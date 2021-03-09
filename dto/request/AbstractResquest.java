/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Apr 24, 2019
 */
@Getter
@Setter
public class AbstractResquest {

    protected int    limit  = 10;

    protected int    offset = 0;

}
