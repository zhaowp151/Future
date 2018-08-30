/**   
 * Copyright © 2018 
 * 
 * @Title: QuerydslUtil.java 
 * @Prject: Future
 * @Package: com.future.core.util 
 * @Description: TODO
 * @author: zhaowp   
 * @date: 2018年8月23日 下午5:21:47 
 * @version: V1.0   
 */
package com.future.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QSort;

import com.future.core.model.base.QWpMain;
import com.future.core.model.base.WpMain;
import com.future.core.util.WhereModel.Operation;
import com.future.core.util.WhereModel.Type;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.ComparableExpression;
import com.querydsl.core.types.dsl.ComparableExpressionBase;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.core.types.dsl.StringPath;

/** 
 * @ClassName: QuerydslUtil 
 * @Description: 查询框架查询
 * @author: zhaowp
 * @date: 2018年8月23日 下午5:21:47  
 */
public class QuerydslUtil {
	
	public Iterable<WpMain> getQueryResult(){
		
		
		
		return null;
		
	}
	
	//建立分页对象
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Pageable buildPageRequest(int pageNumber, int pageSize,QWpMain qWpMain,Map<String, String> map){
		List<OrderSpecifier> orderSpecifiers = new ArrayList<OrderSpecifier>();
		for(String key :map.keySet()) {
			switch (map.get(key)) {
			case "ASC":
				OrderSpecifier ASCSpecifier = new OrderSpecifier(Order.ASC, getPathByFieldType(qWpMain, ReflexUtil.getModelType(qWpMain, key), key));
				orderSpecifiers.add(ASCSpecifier);
				break;
			case "DESC":
				OrderSpecifier DESCSpecifier = new OrderSpecifier(Order.DESC, getPathByFieldType(qWpMain, ReflexUtil.getModelType(qWpMain, key), key));
				orderSpecifiers.add(DESCSpecifier);
				break;
			default:
				break;
			}
			
		}
		QSort sort = new QSort(orderSpecifiers.toArray(new OrderSpecifier[orderSpecifiers.size()]));
		Pageable pageable = new QPageRequest(pageNumber-1, pageSize,sort);
		return pageable;
	}
	
	//建立查询条件（单表）
	@SuppressWarnings("unchecked")
	public static Predicate buildPredicate(QWpMain qWpMain,WhereModel whereModel) {
		if(whereModel.getType() == null) {
			return getPredicate(qWpMain,whereModel);
		}else {
			return getSpecialPredicate(qWpMain,whereModel);
		}
	};
	
	//得到复杂的where表达式
	private static Predicate getSpecialPredicate(QWpMain qWpMain, WhereModel whereModel) {
		Type type = whereModel.getType();
		List<WhereModel> whereModels = whereModel.getWhereModels();
		for (WhereModel model : whereModels) {
			
		}
		switch (type) {
		case AND:
			
			break;
		case OR:
			
			break;

		default:
			break;
		}
		return null;
	}

	//根据字段类型得到path(非数字型)
	public static ComparableExpression getPathByFieldType(QWpMain qWpMain,String fieldType,String field){
		
		switch (fieldType) {
		case "class java.lang.String":
			return qWpMain.getStringPath(field);
		case "class java.util.Date":
			return qWpMain.getDatePath(field);
		default:
			break;
		}
		return null;
	}
	//根据字段类型得到path(数字型)
	public static NumberExpression getPathByFieldTypeNumber(QWpMain qWpMain,String fieldType,String field){
		
		switch (fieldType) {
		case "class java.lang.Integer":
			return qWpMain.getIntegerPath(field);
		case "class java.lang.Long":
			return qWpMain.getLongPath(field);
		case "class java.lang.Float":
			return qWpMain.getFloatPath(field);
		default:
			break;
		}
		return null;
	}
	//得到where表达式
	public static Predicate getPredicate(QWpMain qWpMain,WhereModel whereModel) {
		String fieldName = whereModel.getFieldName();
		Object fieldValue = whereModel.getFieldValue();
		Operation operation = whereModel.getOperation();
		Number numberFrom = whereModel.getNumberFrom();
		Number numberTo = whereModel.getNumberTo();
		Comparable<?> from = whereModel.getFrom();
		Comparable<?> to = whereModel.getTo();
		Boolean flg = false;
		if(fieldValue != null) {
			flg = Number.class.isAssignableFrom(fieldValue.getClass());
		}
		if(numberFrom != null||numberTo !=null) {
			flg = true;
		}
		switch (operation) {
		case EQ:
			if(flg) {
				return getPathByFieldTypeNumber(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName).eq(fieldValue);
			}else {
				return getPathByFieldType(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName).eq(fieldValue);
			}
		case ISNOTNULL:
			return getPathByFieldType(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName).isNotNull();
		case ISNULL:
			return getPathByFieldType(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName).isNull();
		case GT:
			if(flg) {
				return getPathByFieldTypeNumber(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName).gt((Number) fieldValue);
			}else {
				return getPathByFieldType(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName).gt((Comparable) fieldValue);
			}
		case LT:
			if(flg) {
				return getPathByFieldTypeNumber(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName).lt((Number) fieldValue);
			}else {
				return getPathByFieldType(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName).lt((Comparable) fieldValue);
			}
		case LIKE:
			StringPath path = (StringPath) getPathByFieldType(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName);
			return path.like("%"+(String) fieldValue+"%");
		case GQ:
			if(flg) {
				return getPathByFieldTypeNumber(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName).goe((Number) fieldValue);
			}else {
				return getPathByFieldType(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName).goe((Comparable) fieldValue);
			}
		case LQ:
			if(flg) {
				return getPathByFieldTypeNumber(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName).loe((Number) fieldValue);
			}else {
				return getPathByFieldType(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName).loe((Comparable) fieldValue);
			}
		case BETWEEN:
			if(flg) {
				return getPathByFieldTypeNumber(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName).between(numberFrom,numberTo);
			}else {
				return getPathByFieldType(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName).between(from, to);
			}
		case NOTBETWEEN:
			if(flg) {
				return getPathByFieldTypeNumber(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName).notBetween(numberFrom,numberTo);
			}else {
				return getPathByFieldType(qWpMain, ReflexUtil.getModelType(qWpMain, fieldName), fieldName).notBetween(from, to);
			}
		default:
			break;
		}
		return null;
	}
}
