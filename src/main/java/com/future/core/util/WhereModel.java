/**   
 * Copyright © 2018 
 * 
 * @Title: WhereModel.java 
 * @Prject: Future
 * @Package: com.future.core.util 
 * @Description: TODO
 * @author: zhaowp   
 * @date: 2018年8月30日 上午10:59:43 
 * @version: V1.0   
 */
package com.future.core.util;

import java.util.List;

/** 
 * @ClassName: WhereModel 
 * @Description: 查询条件类
 * 1:当type字段不赋值时,fieldName,fieldValue,fieldType,operation字段必须赋值，且whereModels赋值与否与查询结果无关;
 * 2:当type字段赋值时,fieldName,fieldValue,fieldType,operation字段赋值与否与查询结果无关,whereModels需要赋值;
 * 3:当操作为BETWEEN介于类型时,numberFrom,numberTo两个字段是要查询的 数字类型的 两个端点,from,to是要查询的 非数字类型的 两个端点.
 * @author: zhaowp
 * @date: 2018年8月30日 上午10:59:43  
 */
public class WhereModel {
	//类型
	private Type type;
	//字段名字
	private String fieldName;
	//字段对应的值
	private Object fieldValue;
	//操作类型,默认操作EQ
	private Operation operation = Operation.EQ;
	//开始点
	private Number numberFrom;
	private Comparable<?> from;
	//结束点
	private Number numberTo;
	private Comparable<?> to;
	//子节点
	private List<WhereModel> whereModels;
	
	/**
	 * @return the numberFrom
	 */
	public Number getNumberFrom() {
		return numberFrom;
	}

	/**
	 * @param numberFrom the numberFrom to set
	 */
	public void setNumberFrom(Number numberFrom) {
		this.numberFrom = numberFrom;
	}

	/**
	 * @return the from
	 */
	public Comparable<?> getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(Comparable<?> from) {
		this.from = from;
	}

	/**
	 * @return the numberTo
	 */
	public Number getNumberTo() {
		return numberTo;
	}

	/**
	 * @param numberTo the numberTo to set
	 */
	public void setNumberTo(Number numberTo) {
		this.numberTo = numberTo;
	}

	/**
	 * @return the to
	 */
	public Comparable<?> getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(Comparable<?> to) {
		this.to = to;
	}

	/**
	 * @return the whereModels
	 */
	public List<WhereModel> getWhereModels() {
		return whereModels;
	}

	/**
	 * @param whereModels the whereModels to set
	 */
	public void setWhereModels(List<WhereModel> whereModels) {
		this.whereModels = whereModels;
	}

	/**
	 * @return the fieldValue
	 */
	public Object getFieldValue() {
		return fieldValue;
	}

	/**
	 * @param fieldValue the fieldValue to set
	 */
	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}

	/**
	 * @return the operation
	 */
	public Operation getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public enum Type {
		OR,AND
	}
	//EQ等于,ISNOTNULL不是空,ISNULL是空,GT大于,LT小于,LIKE模糊查询,GQ大于等于,LQ小于等于,BETWEEN介于（包含两端）,NOTBETWEEN不介于（不包含两端）
	public enum Operation {
		EQ, ISNOTNULL,ISNULL,GT, LT,LIKE,GQ,LQ,BETWEEN,NOTBETWEEN
	}
}
