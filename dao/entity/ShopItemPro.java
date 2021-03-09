package com.vtc.gateway.scoinv2api.common.dao.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by phucnguyen on 26/04/2018.
 */
@Entity
@Table(name = "tblShopItemPro")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShopItemPro {
    @Id
    @GeneratedValue
    private Long   id;

    private long   shopItem;

    private long   shopPromotion;

    private String tagView;

    private long   newPrice;

    private int    quantity;

}
