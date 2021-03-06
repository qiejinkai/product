package dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qjk.dao.IUserDao;
import com.qjk.data.User;
import com.qjk.service.IUserService;
import com.qjk.util.DigestUtil;


@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestUserDao extends AbstractJUnit4SpringContextTests{
	
	@Resource(name="userDaoImpl")
	IUserDao userDao;
	@Resource
	IUserService UserService;
	
	@Test
	public void testUserDaoInsert(){
		
		User user = new User();
		user.setNick("qiejinkai123");
		user.setPhone("13051701098");
		user.setEmail("qiejinkai@126.com");
		user.setLogo("");
		user.setPassword(DigestUtil.encodePassword("123456"));
				
		UserService.addUser(user);
		
		System.out.println(user.getUid());
		
		//System.out.println(mood.getObjectId());
		
	}
	
	@Test
	public void testUserDaoSelectOne(){
		User user = UserService.findUserById(1);
		System.out.println(user.getNick()+","+user.getPhone()+","+user.getEmail());
//		System.out.println(user.getOptions().size());
//		for (UserOption option : user.getOptions()) {
//			System.out.println(option.getName()+","+option.getValue());
//		}
	}
	
	@Test
	public void testUserService(){
		User user = UserService.findUserById(3);

		System.out.println(user.getNick()+","+user.getPhone()+","+user.getEmail());
		
		user.setNick("你好");
		UserService.updateUser(user);
		
		 user = UserService.findUserById(3);

		System.out.println(user.getNick()+","+user.getPhone()+","+user.getEmail());
		
		UserService.deleteUser(user);
		
		
		
	}
	
	@Test
	public void testUserServiceQuery(){
		List<User> list = UserService.queryUser();
		
		for (User user : list) {

			System.out.println(user.getNick()+","+user.getPhone()+","+user.getEmail());
			
		}
		
	}


	
	
	
	
}
