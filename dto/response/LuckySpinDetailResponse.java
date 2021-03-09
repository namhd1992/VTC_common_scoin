/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vtc.gateway.scoinv2api.common.dao.entity.LuckySpin;
import com.vtc.gateway.scoinv2api.common.dao.entity.LuckySpinSetting;
import com.vtc.gateway.scoinv2api.common.dao.entity.SpinItem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 8, 2019
 */
@Setter
@Getter
@NoArgsConstructor
public class LuckySpinDetailResponse {
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<SpinItem>                    itemOfSpin;

    private LuckySpin                         luckySpin;

    private List<LuckySpinSetting>            settings;

    private UserTurnSpinDetailResponse        userTurnSpin;

}
