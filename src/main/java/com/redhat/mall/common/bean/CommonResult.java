package com.redhat.mall.common.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult<T> {
    /**
     * 状态码
     */
    private int code = 0;

    /**
     * 提示信息
     */
    private String message = "success";

    /**
     * 总数
     */
    private long total;

    /**
     * 数据封装
     */
    private T data;
}
