package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springrest.springrest.entity.User;

public interface Userdao extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.userName = ?1 AND u.password = ?2 AND u.role = ?3")
	public User findByUserNameAndPasswordAndRole(String userName,String password, String role);
}
