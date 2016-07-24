package com.qjk.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoImpl<T> {
	
	@Resource
	SqlSessionTemplate sqlSessionTemplate;
	
	protected void insert(String statement,T t){
		sqlSessionTemplate.insert(statement, t);
	}
	protected void delete(String statement,long id){
		sqlSessionTemplate.delete(statement, id);
	}
	protected T selectOne(String statement,long id){
		return sqlSessionTemplate.selectOne(statement, id);
	}
	protected List<T> selectList(String statement){
		return sqlSessionTemplate.selectList(statement);
	}
	
}
