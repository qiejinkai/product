package com.qjk.dao;

import java.util.List;

import com.qjk.data.User;

public interface IUserDao {
	
	public void insert(User user);
	
	public void delete(long id);
	
	public User selectOne(long id);
	
	public List<User> select();
}
