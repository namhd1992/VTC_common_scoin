package com.vtc.gateway.scoinv2api.common.dao.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by phucnguyen on 26/12/2017.
 */
@Entity
@Table(name = "tblCarousel")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Carousel {
    
    @Id
    @GeneratedValue
    private Long   id;

    private String name;

    private String urlImage;

    private String content;

    private String typeCarousel;

    private int    position;

    private String status;

    private String urlView;

}
