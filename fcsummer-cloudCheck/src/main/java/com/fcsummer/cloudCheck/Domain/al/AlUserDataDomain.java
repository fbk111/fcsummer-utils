package com.fcsummer.cloudCheck.Domain.al;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: UserDataDTO
 * @Author Fcsummer
 * @Package com.fcsummer.cloudCheck.Domain
 * @Date 2023/8/27 9:53
 * @description:
 */
@NoArgsConstructor
@Data
public class AlUserDataDomain {
    /**
     * dingDingRobotUrl
     */
    private String dingDingRobotUrl;
    /**
     * encourageDesc
     */
    private String encourageDesc;
    /**
     * feedBackSwitch
     */
    private Boolean feedBackSwitch;
    /**
     * followingDesc
     */
    private String followingDesc;


}
