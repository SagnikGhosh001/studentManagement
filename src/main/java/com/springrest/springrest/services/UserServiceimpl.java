package com.springrest.springrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.Userdao;
import com.springrest.springrest.entity.User;
@Service
public class UserServiceimpl implements UserService {
	@Autowired
	Userdao userdao;
	
	@Override
	public User login(String userName, String password,String role) {
		User user=userdao.findByUserNameAndPasswordAndRole(userName, password,role);
		return user;
	}

}
