package com.aowin.dao;

import com.aowin.model.User;

public interface UserMapper {
	public String checkUser(User user);
	public int authId(User user);

}
