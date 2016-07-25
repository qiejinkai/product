package com.qjk.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qjk.dao.ISmsDao;
import com.qjk.data.Sms;

@Repository
public class SmsDaoImpl extends BaseDaoImpl<Sms> implements ISmsDao{

	public int addSms(Sms sms) {
		
		return sqlSessionTemplate.insert("insertSms",sms);
	}

	public List<Sms> querySmsList(int[] status) {
		return sqlSessionTemplate.selectList("selectSmsList",status);
	}

	public int updateSms(Sms sms) {
		return sqlSessionTemplate.update("updateSms",sms);
	}

}
