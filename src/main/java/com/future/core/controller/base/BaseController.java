/**   
 * Copyright © 2018 
 * 
 * @Title: BaseController.java 
 * @Prject: Future
 * @Package: com.future.core.controller.base 
 * @Description: TODO
 * @author: zhaowp   
 * @date: 2018年8月20日 上午11:09:58 
 * @version: V1.0   
 */
package com.future.core.controller.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;

/** 
 * @ClassName: BaseController 
 * @Description: TODO
 * @author: zhaowp
 * @date: 2018年8月20日 上午11:09:58  
 */
public abstract class BaseController {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public Pageable buildPageRequest(){
		
		
		return null;
		
	}
}
