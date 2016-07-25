package com.qjk.dao;

import java.util.List;

import com.qjk.data.Sms;

/**
 * 短信
 * @author qiejinkai
 *
 */
public interface ISmsDao {

	public int addSms(Sms sms);
	public List<Sms> querySmsList(int[] status);
	public int updateSms(Sms sms);
}
