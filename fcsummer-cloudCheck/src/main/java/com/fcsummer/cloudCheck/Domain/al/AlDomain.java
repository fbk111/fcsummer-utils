package com.fcsummer.cloudCheck.Domain.al;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Title: AlDomain
 * @Author Fcsummer
 * @Package com.fcsummer.cloudCheck.Domain
 * @Date 2023/8/27 9:52
 * @description: 阿里接受access_token实体类
 */
@NoArgsConstructor
@Data
public class AlDomain {


    /**
     * defaultSboxDriveId
     */
    private String defaultSboxDriveId;
    /**
     * role
     */
    private String role;
    /**
     * deviceId
     */
    private String deviceId;
    /**
     * userName
     */
    private String userName;
    /**
     * needLink
     */
    private Boolean needLink;
    /**
     * expireTime
     */
    private String expireTime;
    /**
     * pinSetup
     */
    private Boolean pinSetup;
    /**
     * needRpVerify
     */
    private Boolean needRpVerify;
    /**
     * avatar
     */
    private String avatar;
    /**
     * userData
     */
    private AlUserDataDomain userData;
    /**
     * tokenType
     */
    private String tokenType;
    /**
     * accessToken
     */
    private String accessToken;
    /**
     * defaultDriveId
     */
    private String defaultDriveId;
    /**
     * domainId
     */
    private String domainId;
    /**
     * refreshToken
     */
    private String refreshToken;
    /**
     * isFirstLogin
     */
    private Boolean isFirstLogin;
    /**
     * userId
     */
    private String userId;
    /**
     * nickName
     */
    private String nickName;
    /**
     * existLink
     */
    private List<?> existLink;
    /**
     * state
     */
    private String state;
    /**
     * expiresIn
     */
    private Integer expiresIn;
    /**
     * status
     */
    private String status;
}
