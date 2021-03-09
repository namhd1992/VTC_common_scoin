package com.vtc.gateway.scoinv2api.common.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
@Table(name = "tblGiftcodeEvent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GiftcodeEvent {
    @Id
    @GeneratedValue
    private Long     id;

    private String   giftCodeFile;

    private String   urlDownloadAndroid;

    private String   androidPackage;

    private String   urlDownloadiOS;

    private String   iosSchemes;

    private String   urlShareFB;

    private int      numberGiftcode;

    private int      numberGiftcodeLost = 0;

    @Temporal(TemporalType.TIMESTAMP)
    private Date     dateStartEvent;

    @Temporal(TemporalType.TIMESTAMP)
    private Date     dateEndEvent;

    @Transient
    private String   defaultImage;

    @Transient
    private String   title;

    private String   pushNotification;

    private String   gameDownloadName;

    private String   messageNotifi;

    private int      numberInstall;

    private long     scoinGameId;

//    @ManyToMany
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @JoinTable(name = "tblGiftcodeEvent_Condition",
//            joinColumns = @JoinColumn(name = "giftcodeEvent"),
//            inverseJoinColumns = @JoinColumn(name = "giftcodeCondition"))
//    private List<TblGiftcodeCondition> giftcodeCondition;

    @ManyToOne
    private UserInfo createBy;

//    @OneToOne(mappedBy="giftcodeEvent")
//    private TblNewsOverview article;

//    @ManyToOne
//    @JoinColumn(name = "inGame")
//    private SplayGame inGame;

    private int      price;

    private int      vipLevel;

    private int      showing;

    @Transient
    private String   giftcodeLost;

}
