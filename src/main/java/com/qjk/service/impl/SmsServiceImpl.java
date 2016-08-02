package com.qjk.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qjk.dao.ISmsDao;
import com.qjk.data.Sms;
import com.qjk.exception.SmsException;
import com.qjk.service.ISmsService;
import com.qjk.util.Value;


public class SmsServiceImpl implements ISmsService {
	private ISmsDao smsDao;

	public Sms sendSms(String phone, String content) throws SmsException {
		if (Value.isEmpty(phone)) {
			throw new SmsException("手机号不能为空");
		}
		if (Value.isEmpty(content)) {
			throw new SmsException("短信内容不能为空");
		}
		Sms sms = new Sms();
		sms.setContent(content);
		sms.setPhone(phone);
		sms.setCtime(new Date().getTime()/1000);
		int result = smsDao.addSms(sms);
		if(result == 0){

			throw new SmsException("插入短信数据失败");
		}
		return sms;

	}

	public List<Sms> querySmsList(int[] status) throws SmsException {
		
		return smsDao.querySmsList(status);
	}

	public void updateSms(Sms sms) throws SmsException {
		if(sms != null){
			int result = smsDao.updateSms(sms);
			if(result == 0){
				throw new SmsException("修改短信数据失败");
			}
		}	

	}

}
