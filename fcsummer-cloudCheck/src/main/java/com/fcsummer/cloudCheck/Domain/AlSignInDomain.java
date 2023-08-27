package com.fcsummer.cloudCheck.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: AlSignInDomain
 * @Author Fcsummer
 * @Package com.fcsummer.cloudCheck.Domain
 * @Date 2023/8/27 10:02
 * @description: al实体类
 */
@NoArgsConstructor
@Data
public class AlSignInDomain {

    /**
     * success
     */
    private Boolean success;
    /**
     * code
     */
    private Object code;
    /**
     * message
     */
    private Object message;
    /**
     * totalCount
     */
    private Object totalCount;
    /**
     * nextToken
     */
    private Object nextToken;
    /**
     * maxResults
     */
    private Object maxResults;
    /**
     * result
     */
    private ResultDTO result;
    /**
     * arguments
     */
    private Object arguments;
}
