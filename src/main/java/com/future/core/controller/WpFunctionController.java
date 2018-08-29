/**   
 * Copyright © 2018 
 * 
 * @Title: WpFunctionController.java 
 * @Prject: Future
 * @Package: com.future.core.controller 
 * @Description: TODO
 * @author: zhaowp   
 * @date: 2018年8月20日 上午11:11:40 
 * @version: V1.0   
 */
package com.future.core.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QSort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.ls.LSInput;

import com.future.core.controller.base.BaseController;
import com.future.core.dao.WpFunctionRepository;
import com.future.core.dao.WpScopeRepository;
import com.future.core.model.WpFunction;
import com.future.core.model.WpScope;
import com.future.core.model.base.QWpMain;
import com.future.core.model.base.WpMain;
import com.future.core.util.RequestResult;
import com.future.core.util.ResultUtil;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;

/** 
 * @ClassName: WpFunctionController 
 * @Description: TODO
 * @author: zhaowp
 * @date: 2018年8月20日 上午11:11:40  
 */
@Controller
@RequestMapping("/wcfunction")
public class WpFunctionController extends BaseController{
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	WpFunctionRepository functionRepository;
	@Autowired
	WpScopeRepository scopeRepository;
	@Autowired
	EntityManager em;
	
	//删除当前操作员
	@RequestMapping("index")
	@ResponseBody
	public RequestResult<WpMain> deleteEntity(Long id) {
		WpFunction function = new WpFunction();
		function.setFlg("d");
		function.setCreateTime(new Date());
		WpScope scope = new WpScope();
		scope.setCode("d");
		QWpMain wpFunction = QWpMain.getQWpMain("core", "wpFunction");
		JPAQueryFactory query = new JPAQueryFactory(em);
		//QueryResults<Model> functions = query.select(Projections.bean(Model.class,qWpScope.code.as("ceshi"))).from(qWpScope).fetchResults();
		
		
		List<OrderSpecifier<Long>> orderSpecifiers = new ArrayList<OrderSpecifier<Long>>();
		
		OrderSpecifier<Long> id1 = new OrderSpecifier<>(Order.ASC, wpFunction.getLongPath("id"));
		orderSpecifiers.add(id1);
		QSort sort = new QSort(orderSpecifiers.toArray(new OrderSpecifier[orderSpecifiers.size()]));
		Pageable pageable = new QPageRequest(0, 9,sort);
		Iterable<WpFunction> wpFunctions = functionRepository.findAll(wpFunction.getStringPath("flg").eq("d").or(wpFunction.getLongPath("id").eq(21L)),pageable);
//		scopeRepository.save(scope);
//		functionRepository.save(function);
//		System.out.println(SpringContextHolder.getBean("wpFunctionRepository"));
		return ResultUtil.success(wpFunctions);
	}
}
