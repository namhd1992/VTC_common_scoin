package com.vtc.gateway.scoinv2api.common.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by phucnguyen on 03/04/2018.
 */
@Entity
@Table(name = "tblSplayTag")
@Setter
@Getter
@NoArgsConstructor
public class GameTag {

    @Id
    @GeneratedValue
    private Long   id;

    private String name;

    private String typeName;

    private String backgroundColor;

}
