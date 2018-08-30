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

import java.util.List;

import com.future.core.model.base.WpMain;

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
    //数据条数
    private Long count;

    /**
     * 要返回的数据
     */
    private List<? extends WpMain> data;

    /**
     * 本次请求的说明信息
     */
    private String msg;
    
    

    /**
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}

	/**
	 * @return the data
	 */
	public List<? extends WpMain> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<? extends WpMain> data) {
		this.data = data;
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

    @Override
    public String toString() {
        return "RequestResult{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
