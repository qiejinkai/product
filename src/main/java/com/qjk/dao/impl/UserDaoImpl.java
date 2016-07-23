package com.qjk.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qjk.dao.IUserDao;
import com.qjk.data.User;


/**
 * 
 * @author qiejinkai
 *
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

	public void insert(User user) {
		
		this.sqlSessionTemplate.insert("insert",user);
		
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	public User selectOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
