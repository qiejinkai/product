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
	
	public static void main(String[] args) {
		A a = new A();
		a.setName("王者");
		a.setValue("123");
		B b = new B();
		b.setName("lalala");
		b.setA(a);
		
		B b1 = (B)b.clone();
		System.out.println(b.getName());
		System.out.println(b1.getName());
		
		b1.setName("dododo");
		System.out.println(b.getName());
		System.out.println(b1.getName());
		
		A a1 = new A();
		a1.setName("qiejinkai");
		a1.setValue("2344");
		
		//b.setA(a1);
		
		b1.getA().setName("asd");
		System.out.println(b.getA().getName());
		System.out.println(b1.getA().getName());
		
		
		
		
	}
	
	
}

class A  implements Cloneable{
	private String name;
	private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
}

class B implements Cloneable{
	private String name;
	private A a;
	
	@Override
	protected Object clone() {
		
		B o = null;
		
		try {
			o=(B)super.clone();
			o.a=(A)a.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public A getA() {
		return a;
	}
	public void setA(A a) {
		this.a = a;
	}
	
}

	
