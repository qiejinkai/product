package com.qjk.dao;

import java.util.List;

import com.qjk.data.User;

public interface IUserDao {
	
	public void addUser(User user);
	
	public void deleteUser(long id);
	
	public User findUserById(long id);
	
	public void updateUser(User user);
	
	public List<User> selectUsers();
}
