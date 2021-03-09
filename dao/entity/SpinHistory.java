package com.vtc.gateway.scoinv2api.common.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by phucnguyen on 26/06/2017.
 */
@Entity
@Table(name = "tblSpinHistory")
@Setter
@Getter
@NoArgsConstructor
public class SpinHistory {
    @Id
    @GeneratedValue
    private int        id;

    @ManyToOne
    @JoinColumn(name = "userInfo")
    private UserInfo   userInfo;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spinEvent")
    private LuckySpin  spinEvent;

    @ManyToOne
    @JoinColumn(name = "item")
    private ItemOfSpin item;

    @CreationTimestamp
    private Date       createOn;

    private String     description;

    private String     status;

    private long       value;

    private String     message;

    private String     deviceId;

    @Transient
    private int        itemId;

    @Transient
    private String     itemName;

    @Transient
    private String     defaultImage;

    @Transient
    private String     luckyspinName;

}
