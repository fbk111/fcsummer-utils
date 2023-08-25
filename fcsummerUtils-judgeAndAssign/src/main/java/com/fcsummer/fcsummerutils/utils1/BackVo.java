package com.fcsummer.fcsummerutils.utils1;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Title: BackVo
 * @Author Fcsummer
 * @Package com.fcsummer.fcsummerutils.utils1
 * @Date 2023/8/24 19:59
 * @description: 返回实体类
 */
@Data
@ToString
public class BackVo<T> {

    private boolean isContainsEmpty;

    private List<String> callBackPropertyList;

    private T backObject;

}
