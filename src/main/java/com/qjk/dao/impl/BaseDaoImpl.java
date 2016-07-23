package com.qjk.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoImpl {
	
	@Resource
	SqlSessionTemplate sqlSessionTemplate;
	
}
