package com.qjk.dao.impl.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qjk.dao.IUserDao;
import com.qjk.data.User;

@Repository
public class HUserDaoImpl extends HBaseDaoImpl<User> implements IUserDao{

	public int addUser(User user) {
		this.save(user);
		return 0;
	}

	public int deleteUser(long id) {
		this.delete(User.class,id);
		return 0;
	}

	public User findUserById(long id) {
		
		return this.findById(User.class,id);
	}

	public int updateUser(User user) {
		this.update(user);
		return 0;
	}

	public List<User> selectUsers() {
		
		return (List<User>)this.findListByHQL("from User ", null);
	}

	public User findUserByAccount(String account) {
		// TODO Auto-generated method stub
		return this.findOneByHQL("from User where phone=? or email=?", account,account);
	}

}
