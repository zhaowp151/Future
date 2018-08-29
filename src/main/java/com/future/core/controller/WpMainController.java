/**   
 * Copyright © 2018 
 * 
 * @Title: WpMainController.java 
 * @Prject: Future
 * @Package: com.future.core.controller 
 * @Description: TODO
 * @author: zhaowp   
 * @date: 2018年8月22日 下午2:36:12 
 * @version: V1.0   
 */
package com.future.core.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.future.core.controller.base.BaseController;
import com.future.core.dao.base.BaseRepository;
import com.future.core.model.base.WpMain;
import com.future.core.service.impl.WpMainServiceImpl;
import com.future.core.util.SpringContextHolder;

/** 
 * @ClassName: WpMainController 
 * @Description: 公用的增删改查接口
 * @author: zhaowp
 * @date: 2018年8月22日 下午2:36:12  
 */
@Controller
@RequestMapping("/wpMain")
public class WpMainController extends BaseController{
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	//公共的添加方法
	@RequestMapping(value="{sysName}/{modelName}/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addWpMainModel(@PathVariable("sysName") String sysName,@PathVariable("modelName") String modelName,@RequestParam Map<Object, Object> map){
		BaseRepository<WpMain, Long> baseRepository = SpringContextHolder.getBean("wpFunctionRepository");
//		baseRepository.save(wpMain);
		WpMainServiceImpl impl = new WpMainServiceImpl();
		impl.createWpMain(sysName, modelName, map);
		
		return null;
		
	}
}
