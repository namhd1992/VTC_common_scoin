package com.vtc.gateway.scoinv2api.common.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 28, 2019
 */
@Entity
@Table(name = "tblGiftcode")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Giftcode {
    @Id
    @GeneratedValue
    private int           id;

    private String        mainCode;

    private String        subCode;

    @ManyToOne
    @JoinColumn(name = "giftcodeEvent")
    private GiftcodeEvent giftcodeEvent;

    @ManyToOne
    @JoinColumn(name = "userLost")
    private UserInfo      userLost;

    private String        deviceID;

    @CreationTimestamp
    private Date          createOn;

    @ManyToOne()
    @JoinColumn(name = "itemSpin")
    private ItemOfSpin    itemSpin;

    private long          shopItem;

}
