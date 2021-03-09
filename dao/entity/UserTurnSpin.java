package com.vtc.gateway.scoinv2api.common.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by phucnguyen on 23/06/2017.
 */
@Entity
@Table(name = "tblUserTurnSpin")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserTurnSpin {
    @Id
    @GeneratedValue
    private Long      id;

    @ManyToOne
    @JoinColumn(name = "spinEvent")
    private LuckySpin spinEvent;

    @ManyToOne
    @JoinColumn(name = "userInfo")
    private UserInfo  userInfo;

    private int       turnsBuy  = 0;

    private long      turnsFree = 0;
    
    public UserTurnSpin(UserInfo userInfo, LuckySpin luckySpin) {
        this.userInfo = userInfo;
        this.spinEvent = luckySpin;
    }

}
