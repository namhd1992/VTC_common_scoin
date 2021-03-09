/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 9, 2019
 */
@Entity
@Table(name = "tblFundsCardScoin")
@Setter
@Getter
@NoArgsConstructor
public class FundsCardScoin {
    
    @Id
    @GeneratedValue
    private Long   id;

    @CreationTimestamp
    private Date   createOn;

    // @ManyToOne
    // @JoinColumn(name = "fundsAccount")
    private String fundsAccount;

    private long   fundsBalance;

    private String orgTransID;

    @Column(name = "VTCTransID")
    private String vtcTransID;

    private String dataSign;

    private String mainCodeCard;

    private String seriCard;

    private int    valueCard;

    private Date   expirationDateCard;

    private Long   recipientUser;

    private String status;

}
