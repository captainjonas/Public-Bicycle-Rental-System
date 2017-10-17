package com.aowin.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.aowin.dao.UserMapper;
import com.aowin.model.User;

@Service
public class UserService {
	@Resource
	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public boolean checkUser(User user){
		String password=userMapper.checkUser(user);
		if(password.equals(user.getPassword())){
			return true;
		}else{ 
			return false;
		}
	}
	
	public int getAuthID(User user){
		return userMapper.authId(user);
	}
	
}
