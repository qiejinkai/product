package com.qjk.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import com.qjk.dao.AbstractBaseRedisDao;
import com.qjk.dao.IUserDao;
import com.qjk.data.User;

@Repository
public class UserDaoRedisImpl extends AbstractBaseRedisDao<String, User> implements IUserDao {

	public void insert( final User user) {
		
		 boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {  
	            public Boolean doInRedis(RedisConnection connection)  
	                    throws DataAccessException {  
	                RedisSerializer<String> serializer = getRedisSerializer();  
	                byte[] key  = serializer.serialize(user.getPhone());  
	                byte[] name = serializer.serialize(user.getNick());  
	                return connection.setNX(key, name);  
	            }  
	        });  
		
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	public User selectOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> select() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
