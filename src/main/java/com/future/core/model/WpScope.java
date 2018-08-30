/**   
 * Copyright © 2018 
 * 
 * @Title: WpScope.java 
 * @Prject: Future
 * @Package: com.future.core.model 
 * @Description: TODO
 * @author: zhaowp   
 * @date: 2018年8月20日 下午4:01:15 
 * @version: V1.0   
 */
package com.future.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.future.core.model.base.WpMain;

/** 
 * @ClassName: WpScope 
 * @Description: TODO
 * @author: zhaowp
 * @date: 2018年8月20日 下午4:01:15  
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "WP_SCOPE")
public class WpScope implements WpMain {
	@Id
	@GeneratedValue(generator  = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	private String flg;
	private String code;

	
	
	
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
