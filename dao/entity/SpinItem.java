package com.vtc.gateway.scoinv2api.common.dao.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by phucnguyen on 23/06/2017.
 */
@Entity
@Table(name = "tblSpin_Item")
@Setter
@Getter
@NoArgsConstructor
public class SpinItem {
    @Id
    @GeneratedValue
    private Long       id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spint")
    private LuckySpin  spint;

//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item")
    private ItemOfSpin item;

    private int        quantity;

    private int        position;
    
    private double     ratio;
    
    public SpinItem(LuckySpin spint, ItemOfSpin item) {
        this.spint = spint;
        this.item = item;
    }

}
