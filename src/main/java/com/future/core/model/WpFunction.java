/**   
 * Copyright © 2018 
 * 
 * @Title: WpFunction.java 
 * @Prject: Future
 * @Package: com.future.core.model 
 * @Description: TODO
 * @author: zhaowp   
 * @date: 2018年8月14日 下午4:42:28 
 * @version: V1.0   
 */
package com.future.core.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.future.core.model.base.WpMain;

/** 
 * @ClassName: WpFunction 
 * @Description: TODO
 * @author: zhaowp
 * @date: 2018年8月14日 下午4:42:28  
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "WP_FUNCTION")
public class WpFunction implements WpMain{
	@Id
	@GeneratedValue(generator  = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	private String flg;
	
    @Temporal(TemporalType.DATE)//生成yyyy-MM-dd类型的日期
    //出参时间格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    //入参时，请求报文只需要传入yyyymmddhhmmss字符串进来，则自动转换为Date类型数据
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;


	
	
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the flg
	 */
	public String getFlg() {
		return flg;
	}

	/**
	 * @param flg the flg to set
	 */
	public void setFlg(String flg) {
		this.flg = flg;
	}
	
}
