package dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qjk.dao.IUserDao;
import com.qjk.data.User;


@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestUserDao extends AbstractJUnit4SpringContextTests{
	
	@Resource
	IUserDao userDao;
	
	@Test
	public void testUserDaoInsert(){
		
		User user = new User();
		user.setId(1);
		user.setAge(12);
		user.setNick("qiejinkai");
		user.setPhone("13051701098");
				
		userDao.insert(user);
		
		//System.out.println(mood.getObjectId());
		
	}


	
	
	
	
}
