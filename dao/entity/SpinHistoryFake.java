/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 26, 2019
 */
@Entity
@Table(name = "tblSpinHistoryFake")
@Setter
@Getter
@NoArgsConstructor
public class SpinHistoryFake {
    
    @Id
    @GeneratedValue
    private int    id;

    @CreationTimestamp
    private Date   createOn;

    private String userName;

    private String itemName;

    private String description;
    
}
