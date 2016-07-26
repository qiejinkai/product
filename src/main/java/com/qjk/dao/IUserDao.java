package com.qjk.dao;

import java.util.List;

import com.qjk.data.User;

public interface IUserDao {
	
	public int addUser(User user);
	
	public int deleteUser(long id);
	
	public User findUserById(long id);
	
	public int updateUser(User user);
	
	public List<User> selectUsers();

	public User findUserByAccount(String account);
}
