/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 16, 2019
 */
@Entity
@Table(name = "tblTopupCardHistory")
@Setter
@Getter
@NoArgsConstructor
public class TopupCardHistory {
  
    @Id
    @GeneratedValue
    private Long     id;

    @CreationTimestamp
    private Date     createOn;

    private Long     scoinId;

    @ManyToOne
    @JoinColumn(name = "userInfo")
    private UserInfo userInfo;

    private String   cardType;

    private long     cardValue;

    private long     scoinTransId;

    private long     serviceId;
    
    private boolean luckyWheelUsed;

}
