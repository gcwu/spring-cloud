package com.test.cloud.common.entity;

/**
 *  统一json返回格式
 * */
public class Result {
    /*返回码*/
    private Integer code;
    /*返回信息提示*/
    private String message;
    /*返回的数据*/
    private Object data;

    /**
     * 时间戳
     */
    private String timestamp;



    public Result(){}

    public Result(Integer code,String message,Object data,String timestamp) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp=timestamp;
    }

    @Override
    public String toString() {
        return "Result [code=" + code + ", message=" + message + ", data=" + data +  ", timestamp=" + timestamp +"]";
    }

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
