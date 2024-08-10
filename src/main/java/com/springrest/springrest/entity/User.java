package com.springrest.springrest.entity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;




@Entity
@Table(name = "registration")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "userName",length = 50,unique = true,nullable = false)
	@javax.validation.constraints.NotNull
	private String userName;
	
	
	@Column(length = 50,name = "password",nullable = false)
	@javax.validation.constraints.NotNull
	private String password;
	

	@Column(name = "roles",length = 50,nullable = false)
	@javax.validation.constraints.NotNull
	private String role;
	
	
	public User(int id, String userName, String password, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
