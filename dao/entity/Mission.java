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
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Apr 17, 2019
 */
@NamedQuery(name = "Mission.findAll", query = "SELECT m FROM Mission m")
@Table(name="tblMission")
@Setter
@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mission {
    
    @Id
    @GeneratedValue
    private long     id;

    private String   name;

    private String   description;

    @CreationTimestamp
    private Date     createOn;

    @ManyToOne
    @JoinColumn(name = "createBy")
    private UserInfo createBy;

    @UpdateTimestamp
    private Date     updateOn;

    @ManyToOne
    @JoinColumn(name = "updateBy")
    private UserInfo updateBy;

    private String   status;

    private Integer  action;

    private Long     objectId;

    private String   award;

    private long     valueAward;
    
    private Long     spinAwardId;

    private Long     valueLimit;

    private String   typeLimit;

    @Temporal(TemporalType.TIMESTAMP)
    private Date     fromDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date     toDate;

    private boolean  isCyclic;

    private String   defaultImage;

    private boolean  highLights;

    private String   androidScheme;

    private String   iosScheme;

    private String   objectValue;

}
