package com.qjk.dao;

import java.util.List;

import com.qjk.data.UserOption;

public interface IUserOptionDao {
	
	public void addUserOption(UserOption UserOption);
	
	public void deleteUserOption(long id);
	
	public UserOption findUserOptionById(long id);
	
	public List<UserOption> selectUserOptions();
}
