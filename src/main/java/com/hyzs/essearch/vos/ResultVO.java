package com.hyzs.essearch.vos;

import java.io.Serializable;

/**
 * @program: es-search
 * @description:
 * @author: hux
 * @create: 2020-04-03 10:05
 **/
public class ResultVO<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    public static ResultVO ok() {
        return ok(null);
    }

    public static <T> ResultVO<T> ok(T data) {
        return ok("OK", data);
    }

    public static <T> ResultVO<T> ok(String msg, T data) {
        ResultVO devResult = new ResultVO();
        devResult.setCode(0);
        devResult.setMsg(msg);
        devResult.setData(data);
        return devResult;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

