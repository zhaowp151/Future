/**   
 * Copyright © 2018 
 * 
 * @Title: ReflexUtil.java 
 * @Prject: Future
 * @Package: com.future.core.util 
 * @Description: TODO
 * @author: zhaowp   
 * @date: 2018年8月22日 下午5:53:14 
 * @version: V1.0   
 */
package com.future.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.future.core.model.base.QWpMain;
import com.future.core.model.base.WpMain;

/** 
 * @ClassName: ReflexUtil 
 * @Description: 反射工具
 * @author: zhaowp
 * @date: 2018年8月22日 下午5:53:14  
 */
public class ReflexUtil {
	/**
	 * 通过model名称获取modelclass
	 * @param classname
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Class getClassByModelName(String modelClassName) {
		try {
			Class c = Class.forName(modelClassName);
			return c;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 根据业务模块和实体名称获取model
	 * 
	 * @param business
	 *            业务模块
	 * @param className
	 *            实体名称
	 * @return 实体路径
	 */
	public static String getModelPath(String business, String className) {
		String path = ReflexConfigure.WORK_HEAD + business + ReflexConfigure.WORK_MODEL + className;
		return path;
	}
	
	/**
	 * 根据字典模块和实体名称获取model
	 * 
	 * @param business
	 *            业务模块
	 * @param className
	 *            实体名称
	 * @return 实体路径
	 */
	public static String getDictPath(String business, String className) {
		String path = ReflexConfigure.WORK_HEAD + business + ReflexConfigure.WORK_DICT + className;
		return path;
	}
	
	/**
	 * java反射bean的set方法
	 * 
	 * @param objectClass
	 * @param fieldName
	 * @return
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Method getSetMethod(Class objectClass, String fieldName) {
		try {
			Class[] parameterTypes = new Class[1];
			Field field = objectClass.getDeclaredField(fieldName);
			parameterTypes[0] = field.getType();
			StringBuffer sb = new StringBuffer();
			sb.append("set");
			sb.append(fieldName.substring(0, 1).toUpperCase());
			sb.append(fieldName.substring(1));
			Method method = objectClass.getMethod(sb.toString(), parameterTypes);
			return method;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(fieldName + "不是反射对象中的属性");
		}
		return null;
	}
	/**
	 * 根据实体名称 获取所有实体属性包括父类属性
	 * 
	 * @param business
	 *            业务模块
	 * @param className
	 *            实体名称例如：AcUser
	 * @return map<属性名称，属性类型>
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, String> getModelType(String business, String className) {
		// 反射获取数据类型map<属性名称，属性类型>
		Map<String, String> modelTypeMap = new HashMap<>();
		// 根据实体名称获得calss
		Class model = ReflexUtil.getClassByModelName(getModelPath(business, className));
		// 获取父类class
		Class extModel = model.getSuperclass();
		Field[] fieldmodels = model.getDeclaredFields();
		// 获取反射出的所有属性和类型
		for (int i = 0; i < fieldmodels.length; i++) {
			Field fieldmodel = fieldmodels[i];
			modelTypeMap.put(fieldmodel.getName(), fieldmodel.getType().toString());
		}
		// 如果父类不为空获取父类中的属性和类型
		if (extModel != null) {
			Field[] fieldExtModels = extModel.getDeclaredFields();
			for (int i = 0; i < fieldExtModels.length; i++) {
				Field fieldsmodel = fieldExtModels[i];
				modelTypeMap.put(fieldsmodel.getName(), fieldsmodel.getType().toString());
			}
		}
		return modelTypeMap;
	}
	
	//得到实体某字段类型
	@SuppressWarnings("rawtypes")
	public static String getModelType(QWpMain qWpMain,String field) {
		
		Class model = qWpMain.getqWpMainModel();
		Field[] fields = model.getDeclaredFields();
		for (Field field0 : fields) {
			String fieldName = field0.getName();
			if(fieldName.equals(field)) {
				return field0.getType().toString();
			}
			
		}
		return null;
		
	}
}
