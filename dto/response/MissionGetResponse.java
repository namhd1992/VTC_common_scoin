/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.response;

import java.util.Date;
import java.util.List;

import com.vtc.common.dto.response.MissionProgressDetail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 30, 2019
 */
@Getter
@Setter
@NoArgsConstructor
public class MissionGetResponse {

    private Long                        missionId;

    private String                      missionName;

    private String                      description;

    private String                      actionName;

    private long                        valueAward;
    
    private String                      spinAwardName;

    private Date                        fromDate;

    private Date                        toDate;

    private boolean                     isCyclic;

    private boolean                     isFinish;

    private boolean                     isReceived;

    private long                        objectId;

    private String                      objectValue;

    private String                      androidScheme;

    private String                      iosScheme;

    private Long                        scoinGameId;

    private String                      award;

    private Long                        awardAvailable;

    private Boolean                     condition;

    private String                      missionStatus;

    private Boolean                     highLights;

    private List<MissionProgressDetail> missionProgress;

    private Integer                     missionSatisfying;

}
