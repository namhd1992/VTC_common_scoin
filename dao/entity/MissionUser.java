package com.vtc.gateway.scoinv2api.common.dao.entity;

import java.io.Serializable;
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
@Table(name = "tblMissionUser")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MissionUser implements Serializable {
    
    private static final long serialVersionUID = 1081322660951162886L;

    @Id
    @GeneratedValue
    private Long              id;

    @ManyToOne
    @JoinColumn(name = "mission")
    private Mission           mission;

    @ManyToOne
    @JoinColumn(name = "userInfo")
    private UserInfo          userInfo;

    @CreationTimestamp
    private Date              createOn;

    private String            action;

    private String            description;

    private boolean           isReceived;

    public MissionUser(Mission mission, UserInfo userInfo, Date createOn, String action, String description) {
        this.mission = mission;
        this.userInfo = userInfo;
        this.createOn = createOn;
        this.action = action;
        this.description = description;
    }

}
