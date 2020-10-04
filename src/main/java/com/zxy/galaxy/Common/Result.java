package com.zxy.galaxy.Common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    /**
     * 返回状态
     */
    private String code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    /**
     * 操作成功
     * @param code 返回状态
     * @param msg 返回信息
     * @param data 返回数据
     * @return
     */
    public static Result success(String code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 操作成功
     * @param data 返回数据
     * @return
     */
    public static Result success(Object data){
        return success("200", "操作成功", data);
    }

    /**
     * 操作失败
     * @param code 返回状态
     * @param msg 返回信息
     * @param data 返回数据
     * @return
     */
    public static Result fail(String code, String msg, Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 操作失败
     * @param msg 返回信息
     * @return
     */
    public static Result fail(String msg){
        return fail("500", msg, null);
    }
}
