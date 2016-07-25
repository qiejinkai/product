package com.qjk.service;

import java.util.List;

import com.qjk.data.Sms;
import com.qjk.exception.SmsException;

public interface ISmsService {

	public Sms sendSms(String phone,String content) throws SmsException;
	public List<Sms> querySmsList(int[] status) throws SmsException;
	public void updateSms(Sms sms) throws SmsException;
}
