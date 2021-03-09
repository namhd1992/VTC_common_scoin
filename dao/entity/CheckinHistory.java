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

@Entity
@Table(name = "tblCheckinHistory")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CheckinHistory {
    @Id
    @GeneratedValue
    private Long        id;

    @ManyToOne
    @JoinColumn(name = "userInfo")
    private UserInfo    userInfo;

    @CreationTimestamp
    private Date        createOn;

//    @ManyToOne
//    @JoinColumn(name = "checkinItem")
//    private CheckinItem checkinItem;

}
