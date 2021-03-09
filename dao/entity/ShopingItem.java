package com.vtc.gateway.scoinv2api.common.dao.entity;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Created by phucnguyen on 23/04/2018.
 */
@Entity
@Table(name = "tblShopingItem")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ShopingItem {
    @Id
    @GeneratedValue
    private Long    id;

    private String  name;

    private String  hotTitle;

    @CreationTimestamp
    private Date    createOn;

    private Integer packageId;

    private long    price;

    private String  coinType;

    private long    pricePoint;

    private int     quantity;

    private long    shopId;

    private String  defaultImage;

    private String  bigImage;

    private int     createBy;

    private String  status;

    private String  firstType;

    private String  secondType;

    private long    numberLike;

    private String  description;

    private String  screenShot;

    @Transient
    private long    salePrice;

    @Transient
    private long    saleQuantity;

    private int     rare;

    private int     itemType;

    private boolean hasPromotion;

}
