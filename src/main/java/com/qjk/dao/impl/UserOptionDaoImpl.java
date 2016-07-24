package com.qjk.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qjk.dao.IUserOptionDao;
import com.qjk.data.UserOption;


/**
 * 
 * @author qiejinkai
 *
 */
@Repository
public class UserOptionDaoImpl extends BaseDaoImpl<UserOption> implements IUserOptionDao {

	public void addUserOption(UserOption userOption) {
		
		sqlSessionTemplate.insert("insert",userOption);
		
	}

	public void deleteUserOption(long id) {
		
		sqlSessionTemplate.delete("delete",id);
		
	}

	public UserOption findUserOptionById(long id) {
		
		return sqlSessionTemplate.selectOne("selectOne",id);
	}

	public List<UserOption> selectUserOptions() {

		return sqlSessionTemplate.selectList("selectList");
	}

}
