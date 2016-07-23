package dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qjk.dao.IUserDao;
import com.qjk.data.User;
import com.qjk.util.DigestUtil;


@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestUserDao extends AbstractJUnit4SpringContextTests{
	
	@Resource(name="userDaoImpl")
	IUserDao userDao;
	
	@Test
	public void testUserDaoInsert(){
		
		User user = new User();
		user.setNick("qiejinkai");
		user.setPhone("13051701098");
		user.setEmail("qiejinkai@126.com");
		user.setLogo("");
		user.setPassword(DigestUtil.encodePassword("123456"));
				
		userDao.insert(user);
		
		System.out.println(user.getObjectId());
		
		//System.out.println(mood.getObjectId());
		
	}


	
	
	
	
}
