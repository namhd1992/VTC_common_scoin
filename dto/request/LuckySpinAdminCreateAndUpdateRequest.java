/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.request;

import java.util.List;

import com.vtc.common.constant.Constant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 16, 2019
 */
@Setter
@Getter
@NoArgsConstructor
public class LuckySpinAdminCreateAndUpdateRequest {

    private Long                            spinEventId;

    private String                          name;

    private String                          image;

    private long                            startDate;

    private long                            endDate;

    private String                          description;

    private int                             freeSpinPerDay;

    private int                             freeSpinOnStart;

    private int                             maxSpinPerUser;

    private int                             pricePerSpin;

    private String                          status = Constant.STATUS_ACTIVE;

    private int                             rankingType;

    private long                            dateStartRanking;

    private long                            dateEndRanking;

    private List<LuckySpinAdminItemRequest> itemOfSpin;

}
