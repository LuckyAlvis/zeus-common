package com.dai.shenzhen.zeus.common.core.model;

import com.dai.shenzhen.zeus.common.core.constant.CommonConstants;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * 响应信息主体
 *
 * @param <T>
 * @author lengleng
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String msg;


    @Getter
    @Setter
    private T data;

    public static <T> BaseResponse<T> ok() {
        return restResult(null, CommonConstants.SUCCESS, CommonConstants.INFO_OK);
    }

    public static <T> BaseResponse<T> ok(T data) {
        return restResult(data, CommonConstants.SUCCESS, CommonConstants.INFO_OK);
    }

    public static <T> BaseResponse<T> ok(T data, String msg) {
        return restResult(data, CommonConstants.SUCCESS, msg);
    }

    public static <T> BaseResponse<T> failed() {
        return restResult(null, CommonConstants.FAIL, CommonConstants.INFO_FAIL);
    }

    public static <T> BaseResponse<T> failed(String msg) {
        return restResult(null, CommonConstants.FAIL, msg);
    }

    public static <T> BaseResponse<T> failed(T data) {
        return restResult(data, CommonConstants.FAIL, CommonConstants.INFO_FAIL);
    }

    public static <T> BaseResponse<T> failed(int code, String msg) {
        return restResult(null, code, msg);
    }

    private static <T> BaseResponse<T> restResult(T data, int code, String msg) {
        BaseResponse<T> apiResult = new BaseResponse<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public boolean isOk() {
        return code == CommonConstants.SUCCESS && data != null;
    }
}

