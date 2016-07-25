package com.qjk.service;

import java.util.List;

import com.qjk.data.User;
import com.qjk.exception.UserException;

public interface IUserService {
	
	void addUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(User user);
	
	User login(String account,String password) throws UserException;
	
	User findUserById(long id);
	
	List<User> queryUser();
	
}
