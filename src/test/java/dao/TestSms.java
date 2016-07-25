package dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qjk.dao.ISmsDao;
import com.qjk.dao.IUserDao;
import com.qjk.data.Sms;
import com.qjk.data.User;
import com.qjk.exception.SmsException;
import com.qjk.service.ISmsService;
import com.qjk.service.IUserService;
import com.qjk.util.DigestUtil;


@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSms extends AbstractJUnit4SpringContextTests{
	
	@Resource
	ISmsDao smsDao;
	@Resource
	ISmsService smsService;
	
	@Test
	public void testAdd() throws SmsException{
		
		Sms sms = new Sms();
		sms.setPhone("13051701098");
		sms.setContent("1234");
		sms.setCtime(new Date().getTime()/1000);
		sms  =smsService.sendSms("13051701098", "1234");
		System.out.println(sms.getMessageId());
		
	}
	
	@Test
	public void testQuery() throws SmsException{
		int [] status = {0,200,300};
		List<Sms> list = smsService.querySmsList(status);
		
		for (Sms sms : list) {
			System.out.println(sms.getMessageId());
		}
	}	
	@Test
	public void testUpdate() throws SmsException{
		Sms sms = new Sms();
		sms.setMessageId(1);
		sms.setResponse("成功");
		sms.setStatus(200);
		smsService.updateSms(sms);
	}
	
	
	
}
