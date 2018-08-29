/**   
 * Copyright © 2018 
 * 
 * @Title: WpMainServiceImpl.java 
 * @Prject: Future
 * @Package: com.future.core.service.impl 
 * @Description: TODO
 * @author: zhaowp   
 * @date: 2018年8月22日 下午3:04:08 
 * @version: V1.0   
 */
package com.future.core.service.impl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.support.DefaultConversionService;

import com.future.core.model.base.WpMain;
import com.future.core.service.WpMainService;
import com.future.core.util.ReflexUtil;

/** 
 * @ClassName: WpMainServiceImpl 
 * @Description: TODO
 * @author: zhaowp
 * @date: 2018年8月22日 下午3:04:08  
 */
public class WpMainServiceImpl implements WpMainService{

	
	@Override
	public WpMain createWpMain(String business, String className, Map<Object, Object> map) {
		WpMain wpMain = null;
		// 反射获取数据类型map<属性名称，属性类型>
		Map<String, String> modelTypeMap = new HashMap<>();
		// 获取实体所有属性
		modelTypeMap = ReflexUtil.getModelType(business, className);
		// 根据实体名称获得class
		@SuppressWarnings("unchecked")
		Class<WpMain> model = ReflexUtil.getClassByModelName(ReflexUtil.getModelPath(business, className));
		wpMain = BeanUtils.instantiate(model);
		for (Object key : map.keySet()) {
			try {
				// 先从自身类获取
				Method m = ReflexUtil.getSetMethod(model, key.toString());
				if (m != null) {
					String value0 = modelTypeMap.get(key);
					// 根据反射获取对象类型采用不同方式赋值
					if (value0.equals("class java.lang.String")) {
						String value = (String) map.get(key);
						m.invoke(wpMain, value);
					} else if (value0.equals("class java.util.Date")) {
						String value = (String) map.get(key);
						SimpleDateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-dd");
						Date date = null;
						date = dateFormat.parse(value);
						m.invoke(wpMain, date);
						
					} else if (value0.equals("class java.lang.Long")) {
						Long value;
						if(StringUtils.isNotBlank(map.get(key).toString())) {
							value = Long.valueOf(map.get(key).toString());
						}else {
							value = null;
						}
						
						m.invoke(wpMain, value);
					}else if(value0.contains("class java.lang.Integer")){
						Integer value = Integer.valueOf(map.get(key).toString());
						m.invoke(wpMain, value);
					}else if(value0.contains("class java.lang.Float")){
						Float value = Float.valueOf(map.get(key).toString());
						m.invoke(wpMain, value);
					}else if(value0.contains("com.future")){
					
						int lastindex = value0.lastIndexOf(".");
						String obj = value0.substring(lastindex+1, value0.length());
						Class<?> model0 = ReflexUtil.getClassByModelName(ReflexUtil.getDictPath(business, obj));
						String key0 = map.get(key).toString();
						DefaultConversionService conversionService = new DefaultConversionService();
						m.invoke(wpMain, conversionService.convert(key0, model0));
					}else if (value0.equals("class java.sql.Date")) {
						String value = (String) map.get(key);
						SimpleDateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-dd");
						Date date = null;
						date = dateFormat.parse(value);
						m.invoke(wpMain, date);
						
					}
				}
			} catch (Exception e) {
			}
				
				
		}
		return wpMain;
	}

}
