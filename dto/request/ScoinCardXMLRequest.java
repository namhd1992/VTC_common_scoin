/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 8, 2019
 */
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name="requestBody")
public class ScoinCardXMLRequest {
    
    @XmlElement
    private String requesData;

    @XmlElement
    private String partnerCode;

    @XmlElement
    private String commandType;

    @XmlElement
    private String version;

}
