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
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

	public int addUser(User user) {

		return sqlSessionTemplate.insert("insertUser",user);

	}

	public int deleteUser(long id) {

		return sqlSessionTemplate.delete("deleteUser",id);

	}

	public User findUserById(long id) {

		return sqlSessionTemplate.selectOne("selectUser", id);
	}

	public List<User> selectUsers() {

		return sqlSessionTemplate.selectList("selectUserList");
	}

	public int updateUser(User user) {
		
		return sqlSessionTemplate.update("updateUser", user);
	}
	
	public User findUserByAccount(String account) {
		
		return sqlSessionTemplate.selectOne("selectUserByAccount",account);
	}

}
