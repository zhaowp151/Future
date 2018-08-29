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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.future.core.controller.base.BaseController;
import com.future.core.dao.base.BaseRepository;
import com.future.core.model.base.WpMain;
import com.future.core.service.WpMainService;
import com.future.core.util.RequestResult;
import com.future.core.util.ResultUtil;
import com.future.core.util.SpringContextHolder;
import com.future.core.util.StringUtil;

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
	@Autowired
	WpMainService mainService;
	
	//公共的添加方法（单个添加）
	@RequestMapping(value="{sysName}/{modelName}/add",method=RequestMethod.POST)
	@ResponseBody
	public RequestResult<WpMain> addWpMainModel(@PathVariable("sysName") String sysName,@PathVariable("modelName") String modelName,@RequestParam Map<Object, Object> map){
		List<WpMain> wpMains = new ArrayList<>();
		BaseRepository<WpMain, Long> baseRepository = SpringContextHolder.getBean(StringUtil.lowerCase(modelName)+ "Repository");
		WpMain wpMain = mainService.createWpMain(sysName, modelName, map);
		WpMain reWpMain = baseRepository.save(wpMain);
		wpMains.add(reWpMain);
		return ResultUtil.success(wpMains);
	}
	
	//公共的添加方法（多个添加）(尚不可用)
	@RequestMapping(value="{sysName}/{modelName}/adds",method=RequestMethod.POST)
	@ResponseBody
	public RequestResult<WpMain> addsWpMainModel(@PathVariable("sysName") String sysName,@PathVariable("modelName") String modelName,@RequestParam Map<Object, Object> map){
		BaseRepository<WpMain, Long> baseRepository = SpringContextHolder.getBean(StringUtil.lowerCase(modelName)+ "Repository");
		Iterable<WpMain> wpMains = mainService.createWpMains(sysName, modelName, map);
		List<WpMain> reWpMain = baseRepository.save(wpMains);
		return ResultUtil.success(reWpMain);
	}
	
	//公共的删除方法(单个删除)
	@RequestMapping(value="{sysName}/{modelName}/delete",method=RequestMethod.POST)
	@ResponseBody
	public RequestResult<WpMain> deleteWpMainModel(@PathVariable("sysName") String sysName,@PathVariable("modelName") String modelName,@RequestParam Map<Object, Object> map){
		List<WpMain> wpMains = new ArrayList<>();
		BaseRepository<WpMain, Long> baseRepository = SpringContextHolder.getBean(StringUtil.lowerCase(modelName)+ "Repository");
		WpMain wpMain = mainService.createWpMain(sysName, modelName, map);
		baseRepository.delete(wpMain);;
		return ResultUtil.success(wpMains);
	}
	
	//公共的删除方法(多个删除)（尚不可用）
	@RequestMapping(value="{sysName}/{modelName}/deletes",method=RequestMethod.POST)
	@ResponseBody
	public RequestResult<WpMain> deletesWpMainModel(@PathVariable("sysName") String sysName,@PathVariable("modelName") String modelName,@RequestParam Map<Object, Object> map){
		List<WpMain> wpMains = new ArrayList<>();
		BaseRepository<WpMain, Long> baseRepository = SpringContextHolder.getBean(StringUtil.lowerCase(modelName)+ "Repository");
		WpMain wpMain = mainService.createWpMain(sysName, modelName, map);
		baseRepository.delete(wpMain);;
		return ResultUtil.success(wpMains);
	}
	
	//公共的修改方法
	@RequestMapping(value="{sysName}/{modelName}/edit",method=RequestMethod.POST)
	@ResponseBody
	public RequestResult<WpMain> editWpMainModel(@PathVariable("sysName") String sysName,@PathVariable("modelName") String modelName,@RequestParam Map<Object, Object> map){
		List<WpMain> wpMains = new ArrayList<>();
		BaseRepository<WpMain, Long> baseRepository = SpringContextHolder.getBean(StringUtil.lowerCase(modelName)+ "Repository");
		WpMain wpMain = mainService.createWpMain(sysName, modelName, map);
		baseRepository.saveAndFlush(wpMain);;
		return ResultUtil.success(wpMains);
	}
	
	//公共的查询方法
	@RequestMapping(value="{sysName}/{modelName}/query",method=RequestMethod.POST)
	@ResponseBody
	public RequestResult<WpMain> queryWpMainModel(@PathVariable("sysName") String sysName,@PathVariable("modelName") String modelName,@RequestParam Map<Object, Object> map){
		List<WpMain> wpMains = new ArrayList<>();
		BaseRepository<WpMain, Long> baseRepository = SpringContextHolder.getBean(StringUtil.lowerCase(modelName)+ "Repository");
		WpMain wpMain = mainService.createWpMain(sysName, modelName, map);
		baseRepository.saveAndFlush(wpMain);;
		return ResultUtil.success(wpMains);
	}
}
