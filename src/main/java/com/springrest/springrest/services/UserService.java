package com.springrest.springrest.services;

import com.springrest.springrest.entity.User;

public interface UserService {
	User login(String userName,String password,String role);
}
