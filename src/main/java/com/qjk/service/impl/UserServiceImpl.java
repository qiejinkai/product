package com.qjk.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Value;
import com.qjk.dao.IUserDao;
import com.qjk.data.User;
import com.qjk.service.IUserService;
import com.qjk.util.DigestUtil;
import com.sun.corba.se.impl.io.ValueUtility;

@Service
public class UserServiceImpl implements IUserService {

	@Resource(name="userDaoImpl")
	private IUserDao userDao;

	public void addUser(User user) {
		
		String password = user.getPassword();
		
		if(!com.qjk.util.Value.isEmpty(password)){
			user.setPassword(DigestUtil.encodePassword(password));
		}
		
		userDao.addUser(user);

	}

	public void updateUser(User user) {
			userDao.updateUser(user);
	}

	public void deleteUser(User user) {
		if (user != null && user.getUid() != 0) {
			userDao.deleteUser(user.getUid());
		}

	}

	public User findUserById(long id) {

		return userDao.findUserById(id);

	}

	public List<User> queryUser() {
		return userDao.selectUsers();
	}

}
