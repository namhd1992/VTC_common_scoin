/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Apr 18, 2019
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScoinResponse<T> implements Serializable {

    private static final long serialVersionUID = -6669686067446636607L;

    protected String          status;

    protected String          message;

    protected T               data;

    protected int             totalRecords;

}
