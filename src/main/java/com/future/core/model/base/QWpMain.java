/**   
 * Copyright © 2018 
 * 
 * @Title: QWpMain.java 
 * @Prject: Future
 * @Package: com.future.core.model.base 
 * @Description: TODO
 * @author: zhaowp   
 * @date: 2018年8月23日 下午5:37:06 
 * @version: V1.0   
 */
package com.future.core.model.base;

import java.util.Date;

import javax.annotation.Generated;

import com.future.core.util.ReflexUtil;
import com.future.core.util.StringUtil;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.BeanPath;
import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

/** 
 * @ClassName: QWpMain 
 * @Description: 通用查询对象
 * @author: zhaowp
 * @date: 2018年8月23日 下午5:37:06  
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWpMain extends EntityPathBase<WpMain>{

	public DatePath<java.util.Date> getDatePath(String fieldName){
		return createDate(fieldName, java.util.Date.class);
	}
	public StringPath getStringPath(String fieldName){
		return createString(fieldName);
	}
	public NumberPath<Long> getLongPath(String fieldName){
		return createNumber(fieldName, Long.class);
	}
	public static QWpMain getQWpMain(String business, String className) {
		Class<WpMain> model = ReflexUtil.getClassByModelName(ReflexUtil.getModelPath(business, StringUtil.upperCase(className)));
		return new QWpMain(model,className);
	}
	/** 
	 * @Title:QWpMain
	 * @Description:TODO 
	 * @param type
	 * @param variable 
	 */
	public QWpMain(Class<? extends WpMain> type, String variable) {
		super(type, variable);
	}
}
