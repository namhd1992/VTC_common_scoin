package com.vtc.gateway.scoinv2api.common.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by phucnguyen on 07/03/2017.
 */
@Entity
@Table(name = "tblUserGameRID")
@Getter
@Setter
@NoArgsConstructor
public class UserGameRID {
    @Id
    @GeneratedValue
    private int id;

    private String username;

    private String password;

    @CreationTimestamp
    private Date createOn;

    private String status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userInfo")
    private UserInfo userInfo;

    private int balance = 0;

    public UserGameRID(String username, String password, Date createOn, String status,
                          UserInfo userInfo) {
        this.username = username;
        this.password = password;
        this.createOn = createOn;
        this.status = status;
        this.userInfo = userInfo;
        this.balance = 0;
    }

}
