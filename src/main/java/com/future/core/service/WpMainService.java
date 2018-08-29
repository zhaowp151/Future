/**   
 * Copyright © 2018 
 * 
 * @Title: WpMainService.java 
 * @Prject: Future
 * @Package: com.future.core.service 
 * @Description: TODO
 * @author: zhaowp   
 * @date: 2018年8月22日 下午3:04:30 
 * @version: V1.0   
 */
package com.future.core.service;

import java.util.List;
import java.util.Map;

import com.future.core.model.base.WpMain;

/** 
 * @ClassName: WpMainService 
 * @Description: TODO
 * @author: zhaowp
 * @date: 2018年8月22日 下午3:04:30  
 */
public interface WpMainService {
	//组装单个实体对象
	public WpMain createWpMain(String business, String className, Map<Object, Object> map);
	//组装多个实体对象
	public Iterable<WpMain> createWpMains(String business, String className, Map<Object, Object> map);
}
