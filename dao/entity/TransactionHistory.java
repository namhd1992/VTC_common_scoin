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
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 13, 2019
 */
@Entity
@Table(name = "tblTransactionHistory")
@Setter
@Getter
@NoArgsConstructor
public class TransactionHistory {

    @Id
    @GeneratedValue
    private Long     id;

    private Long     transactionId;

    private String   serviceType;

    private String   sourceType;

    private String   status;

    @CreationTimestamp
    private Date     createOn;

    private long     inputAmount;

    private long     amount;

    private long     fee;

    private long     promotion;

    private long     totalAmount;

    private String   currency;

    private String   dataRequest;

    private String   dataResponse;

    private long     balanceBefore;

    private long     balanceAfter;

    private String   description;

    @Transient
    private int      userId;

    @Transient
    private long     scoinUserId;

    @ManyToOne
    @JoinColumn(name = "senderId")
    private UserInfo sender;

    @ManyToOne
    @JoinColumn(name = "receiverId")
    private UserInfo receiver;

    // @OneToOne(mappedBy ="transactionHistory")
    // private TblBettingTicket bettingTicket;

}
