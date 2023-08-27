package com.fcsummer.cloudCheck.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: RewardDTO
 * @Author Fcsummer
 * @Package com.fcsummer.cloudCheck.Domain
 * @Date 2023/8/27 10:09
 * @description:
 */
@NoArgsConstructor
@Data
public class RewardDTO {
    /**
     * goodsId
     */
    private Object goodsId;
    /**
     * name
     */
    private Object name;
    /**
     * description
     */
    private Object description;
    /**
     * background
     */
    private String background;
    /**
     * color
     */
    private Object color;
    /**
     * action
     */
    private Object action;
    /**
     * detailAction
     */
    private Object detailAction;
    /**
     * notice
     */
    private Object notice;
    /**
     * subNotice
     */
    private Object subNotice;
    /**
     * bottleId
     */
    private Object bottleId;
    /**
     * bottleName
     */
    private Object bottleName;
    /**
     * bottleShareId
     */
    private Object bottleShareId;
}
