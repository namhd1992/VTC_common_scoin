package com.vtc.gateway.scoinv2api.common.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by phucnguyen on 07/03/2017.
 */
@Entity
@Table(name = "tblUserVTC")
@Setter
@Getter
@AllArgsConstructor
public class UserVTC {
    @Id
    @GeneratedValue
    private Long     id;

    private String   username;

    private String   status;

    @CreationTimestamp
    private Date     createOn;

    private Long     scoinId;

    private long     balance;

    private long     xu;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "userInfo")
    private UserInfo userInfo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date     lastCheckInbox;

    @Transient
    private boolean  firstLogin = false;

    public UserVTC() {
        this.balance = 0;
    }

}
