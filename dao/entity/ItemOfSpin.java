package com.vtc.gateway.scoinv2api.common.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by phucnguyen on 23/06/2017.
 */
@Entity
@Table(name = "tblItemOfSpin")
@Setter
@Getter
@AllArgsConstructor
public class ItemOfSpin {
    @Id
    @GeneratedValue
    private Long     id;

    private String   name;

    private String   keyName;

    private long    value;

    private String   type;

    private int      quantity           = 0;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "createBy")
    private UserInfo createBy;

    private String   status;

    private int      isDefault          = 0;

    @CreationTimestamp
    private Date     createOn;

    private int      weight             = 0;

    private String   urlImage;

    private int      defaultPosition    = 1;

    private String   winningTitle;

    private String   wheelTitle;

    private String   description;

    private int      showQuantityClient = 1;

    private boolean  highLights;

    public ItemOfSpin() {
        this.weight = 0;
        this.showQuantityClient = 1;
    }

}
