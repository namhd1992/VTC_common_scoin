package com.vtc.gateway.scoinv2api.common.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by phucnguyen on 07/03/2017.
 */
@Entity
@Table(name = "tblUserInfo")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 7271122944681891518L;

    @Id
    @GeneratedValue
    private Long              id;

    private String            firstName;

    private String            lastName;

    private String            fullName;

    private String            email;

    private String            phoneNumber;

    private String            address;

    @Temporal(TemporalType.TIMESTAMP)
    private Date              dateOfBirth;

    private String            urlAvatar;

    private String            gender;

    private String            status;

    private long              point;

    private String            otpKey;

    private String            notifiKey;

    private String            deviceType;

    private String            deviceId;

    @Transient
    private String            username;

    @ManyToOne
    @JoinColumn(name = "groupRole")
    private GroupRole         groupRole;
    
    @JsonBackReference
    @OneToOne(mappedBy = "userInfo", fetch = FetchType.LAZY)
    private UserVTC userVTC;

    private int               vipLevel;

    private long              splayPoint;

    private String            ref;

    private String            facebookIdMerge;
    
}
