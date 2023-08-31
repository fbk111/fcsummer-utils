package com.fcsummer.cloudCheck.Domain.al;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Title: ResultDTO
 * @Author Fcsummer
 * @Package com.fcsummer.cloudCheck.Domain
 * @Date 2023/8/27 10:09
 * @description:
 */
@NoArgsConstructor
@Data
public class AlSignInResultDomain {
    /**
     * subject
     */
    private String subject;
    /**
     * title
     */
    private String title;
    /**
     * description
     */
    private String description;
    /**
     * isReward
     */
    private Boolean isReward;
    /**
     * blessing
     */
    private String blessing;
    /**
     * signInCount
     */
    private Integer signInCount;
    /**
     * signInCover
     */
    private String signInCover;
    /**
     * signInRemindCover
     */
    private String signInRemindCover;
    /**
     * rewardCover
     */
    private String rewardCover;
    /**
     * pcAndWebRewardCover
     */
    private String pcAndWebRewardCover;
    /**
     * signInLogs
     */
    private List<AlSignInLogsDTO> signInLogs;
}
