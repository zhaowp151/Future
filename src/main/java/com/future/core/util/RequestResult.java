/**   
 * Copyright © 2018 
 * 
 * @Title: RequestResult.java 
 * @Prject: Future
 * @Package: com.future.core.util 
 * @Description: TODO
 * @author: zhaowp   
 * @date: 2018年8月22日 下午2:43:22 
 * @version: V1.0   
 */
package com.future.core.util;

/** 
 * @ClassName: RequestResult 
 * @Description: 对请求结果进行封装
 * @author: zhaowp
 * @date: 2018年8月22日 下午2:43:22  
 */
public class RequestResult<T> {
	/**
     * error code :成功是1,失败是0
     */
    private Integer code;

    /**
     * 要返回的数据
     */
    private Iterable<? extends T> data;

    /**
     * 本次请求的说明信息
     */
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Iterable<? extends T> getData() {
        return data;
    }

    public void setData(Iterable<? extends T> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "RequestResult{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
