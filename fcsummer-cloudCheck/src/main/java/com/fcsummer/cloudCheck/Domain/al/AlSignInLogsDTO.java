package com.fcsummer.cloudCheck.Domain.al;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: SignInLogsDTO
 * @Author Fcsummer
 * @Package com.fcsummer.cloudCheck.Domain
 * @Date 2023/8/27 10:09
 * @description:
 */
@NoArgsConstructor
@Data
public class AlSignInLogsDTO {
    /**
     * day
     */
    private Integer day;
    /**
     * status
     */
    private String status;
    /**
     * icon
     */
    private String icon;
    /**
     * pcAndWebIcon
     */
    private String pcAndWebIcon;
    /**
     * notice
     */
    private String notice;
    /**
     * type
     */
    private String type;
    /**
     * rewardAmount
     */
    private Integer rewardAmount;
    /**
     * themes
     */
    private String themes;
    /**
     * calendarChinese
     */
    private String calendarChinese;
    /**
     * calendarDay
     */
    private String calendarDay;
    /**
     * calendarMonth
     */
    private String calendarMonth;
    /**
     * poster
     */
    private Object poster;
    /**
     * reward
     */
    private AlRewardDTO reward;
    /**
     * isReward
     */
    private Boolean isReward;
}
