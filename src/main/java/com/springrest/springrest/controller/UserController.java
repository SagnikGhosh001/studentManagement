package com.springrest.springrest.controller;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.User;
import com.springrest.springrest.services.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userservice;
	@PostMapping("/login")
	public AuthResponse validate(@RequestBody User user) throws ServletException{
		String jwtToken="";
		if(user.getUserName()==null || user.getPassword()==null || user.getRole()==null)
		{
			throw new ServletException("Please enter username password and role");
		
		}
		String userName=user.getUserName();
		String password=user.getPassword();
		String role=user.getRole();
		user=userservice.login(userName, password,role);
		if(user==null)
			throw new ServletException("User Not found");
		
		jwtToken=Jwts.builder()
				.setSubject(userName)
				.claim("roles", user.getRole())
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey")
				.compact();
		AuthResponse response = new AuthResponse();
        response.setToken(jwtToken);
        response.setUser(user);
        return response;
	}
	public static class AuthResponse {
        private String token;
        private User user;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }
}

