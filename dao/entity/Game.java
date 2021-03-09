package com.vtc.gateway.scoinv2api.common.dao.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by phucnguyen on 05/12/2017.
 */
@Entity
@Table(name = "tblSplayGame")
@Setter
@Getter
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue
    private Long           id;

    @CreationTimestamp
    private Date           createOn;

    @UpdateTimestamp
    private Date           updateOn;

    private String         name;

    private String         keyName;

    private String         defaultImage;

    private String         bigImage;

    private String         website;

    private String         fanpageFB;

    private String         publisher;

    private String         status;

    private String         description;

    private Long           scoinGameId;

    private String         subTitle;

    private long           downloadTurns;

    private String         urlDownloadAndroid;

    private String         urlDownloadIos;

    private String         screenShot;

    private float          pointReview;

    private int            position;

    private int            createBy;

    private long           priorityTag;

    private String         youtubeChannelId;

    private String         youtubeDefaultSearch;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                })
    @JoinTable(name = "tblSplayGame_Tag", joinColumns = @JoinColumn(name = "gameId"), inverseJoinColumns = @JoinColumn(name = "tagId"))
    private List<GameTag> tagsList;

    @Transient
    private long           numberGiftcodeOfGame = 0;

    public Game(String name, String keyName, String defaultImage, String website,
                        String fanpageFB, String publisher, String status, Date createOn) {
        this.name = name;
        this.keyName = keyName;
        this.defaultImage = defaultImage;
        this.website = website;
        this.fanpageFB = fanpageFB;
        this.publisher = publisher;
        this.status = status;
        this.createOn = createOn;
    }

}
