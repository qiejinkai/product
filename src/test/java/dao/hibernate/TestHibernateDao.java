package dao.hibernate;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qjk.dao.IUserDao;
import com.qjk.data.User;
import com.qjk.service.IUserService;
import com.qjk.service.impl.UserServiceImpl;
import com.qjk.util.DigestUtil;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestHibernateDao extends AbstractJUnit4SpringContextTests{
	
	@Resource
	IUserDao userDao;
	
	@Resource
	IUserService userService;
	
	@Resource(name="hibernateSessionFactory")
	SessionFactory sf;
	
	
	
	
	@Test
	public void testAdd(){
		User user = new User();
		user.setEmail("wangzhehaose@sina.com");
		user.setNick("wangzhe");
		user.setPassword(DigestUtil.encodePassword("123456"));
		userDao.addUser(user);
		System.out.println(user.getUid());
	}
	
	@Test
	public void testApplication(){
		Session session = sf.openSession();
		User user = new User();
		user.setEmail("wangzhehaose@sina.com");
		user.setPassword("1234561231231231231231231231231");
		session.beginTransaction();
		session.save(user);
		session.flush();
		System.out.println(user.getUid());
		session.beginTransaction().commit();
		session.close();
	}
}
