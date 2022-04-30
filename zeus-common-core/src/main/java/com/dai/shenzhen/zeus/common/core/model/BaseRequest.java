package com.dai.shenzhen.zeus.common.core.model;

import lombok.Data;

@Data
public class BaseRequest {
    /**
     * 当前页码
     */
    Integer current;

    /**
     * 每页数量
     */
    Integer size;
}
