package com.vtc.gateway.scoinv2api.common.dao.entity;

import javax.persistence.*;

/**
 * Created by phucnguyen on 03/04/2018.
 */
@Entity
@Table(name = "tblSplayTag")
public class TblSplayTag {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "typeName")
    private String typeName;

    @Column(name = "backgroundColor")
    private String backgroundColor;

    public TblSplayTag() {
    }

    public TblSplayTag(String name) {
        this.name = name;
    }

    public TblSplayTag(String name, String typeName) {
        this.name = name;
        this.typeName = typeName;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
