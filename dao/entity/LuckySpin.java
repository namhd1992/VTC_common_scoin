package com.vtc.gateway.scoinv2api.common.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by phucnguyen on 23/06/2017.
 */
@Entity
@Table(name = "tblLuckySpin")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LuckySpin {
    @Id
    @GeneratedValue
    private Long           id;

    private String         name;

    private String         keyName;

    private String         image;

    @CreationTimestamp
    private Date           createOn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date           startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date           endDate;

    @UpdateTimestamp
    private Date           lastUpdate;

    private String         description;
    
    private String         linkLiveStream;

    private int            freeSpinPerDay;

    private long           freeSpinOnStart;

    private int            maxSpinPerUser;

    private int            pricePerSpin;

    private String         status;

    private int            spinTimes   = 0;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "createBy")
    private UserInfo       createBy;

    private boolean        checkDeviceId;

    private int            rankingType = 0;

    @Temporal(TemporalType.TIMESTAMP)
    private Date           dateStartRanking;

    @Temporal(TemporalType.TIMESTAMP)
    private Date           dateEndRanking;

    @OneToMany(mappedBy = "spint", fetch = FetchType.EAGER)
    private List<SpinItem> spinItems   = new ArrayList<>();

}
