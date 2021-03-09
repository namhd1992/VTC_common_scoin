/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 15, 2019
 */
@Entity
@Table(name = "tblLuckyNumber")
@Setter
@Getter
@NoArgsConstructor
public class LuckyNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long    id;

    @CreationTimestamp
    private Date    createOn;

    private String  luckyCode;

    private Long    scoinId;

    private boolean used;

}
