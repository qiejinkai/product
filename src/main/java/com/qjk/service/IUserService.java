package com.qjk.service;

import java.util.List;

import com.qjk.data.User;

public interface IUserService {
	
	void addUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(User user);
	
	User findUserById(long id);
	
	List<User> queryUser();
	
}
