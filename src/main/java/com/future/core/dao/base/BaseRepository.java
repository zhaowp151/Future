/**   
 * Copyright © 2018 
 * 
 * @Title: BaseRepository.java 
 * @Prject: Future
 * @Package: com.future.core.dao.base 
 * @Description: TODO
 * @author: zhaowp   
 * @date: 2018年8月14日 下午4:33:21 
 * @version: V1.0   
 */
package com.future.core.dao.base;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.future.core.model.base.WpMain;

/** 
 * @ClassName: BaseRepository 
 * @Description: 所有dao接口都要继承
 * @author: zhaowp
 * @date: 2018年8月14日 下午4:33:21  
 */
@NoRepositoryBean
public interface BaseRepository<T extends WpMain,PK extends Serializable> extends JpaRepository<T,PK>,JpaSpecificationExecutor<T>,QueryDslPredicateExecutor<T> {

}
