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

	public void addUser(User user) {

		sqlSessionTemplate.insert("insertUser",user);

	}

	public void deleteUser(long id) {

		sqlSessionTemplate.delete("deleteUser",id);

	}

	public User findUserById(long id) {

		return sqlSessionTemplate.selectOne("selectUser", id);
	}

	public List<User> selectUsers() {

		return sqlSessionTemplate.selectList("selectUserList");
	}

	public void updateUser(User user) {
		
		sqlSessionTemplate.update("updateUser", user);
	}

}
