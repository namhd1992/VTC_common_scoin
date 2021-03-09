/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 12, 2019
 */
@Getter
@Setter
@NoArgsConstructor
public class CallApiScoinBaseResponse<T> {

    private boolean status;

    private Integer error_code;

    private String  error_desc;

    private T       data;

}
