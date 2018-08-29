/**   
 * Copyright © 2018 
 * 
 * @Title: ResultUtil.java 
 * @Prject: Future
 * @Package: com.future.core.util 
 * @Description: TODO
 * @author: zhaowp   
 * @date: 2018年8月22日 下午2:42:11 
 * @version: V1.0   
 */
package com.future.core.util;

import java.util.ArrayList;
import java.util.List;

import com.future.core.model.base.WpMain;

/** 
 * @ClassName: ResultUtil 
 * @Description: 封装请求结果的工具类
 * @author: zhaowp
 * @date: 2018年8月22日 下午2:42:11  
 */
public class ResultUtil {
	 /**
     * 成功请求的结果封装
	 * @param <T>
     * @param t
     * @param <T>
     * @return
     */
    public static RequestResult<WpMain> success(Iterable<? extends WpMain> t) {
        RequestResult<WpMain> result = new RequestResult<WpMain>();
        result.setCode(1);
        result.setMsg("success");
        
        Class<Iterable<? extends WpMain>> tType = (Class<Iterable<? extends WpMain>>) t.getClass();
    	String type = tType.getName();
    	if(!"java.util.ArrayList".equals(type)) {
    		List<WpMain> wpMains = new ArrayList<>();
    		for (WpMain wpMain : t) {
    			wpMains.add(wpMain);
			}
    		result.setData(wpMains);
    	}else {
    		result.setData(t);
    	}
        return result;
    }

    /**
     * 失败请求的结果封装
     * @param msg
     * @param <T>
     * @return
     */
    public static RequestResult<WpMain> fail(String msg) {
        RequestResult<WpMain> result = new RequestResult<WpMain>();
        result.setCode(1);
        result.setData(null);
        result.setMsg(msg);
        return result;
    }
}
