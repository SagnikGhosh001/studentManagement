package com.springrest.springrest.entity;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;





@Entity
@Table(name = "register_Student")
public class Student extends User {
	@Column(name = "name",nullable = false)
	@javax.validation.constraints.NotNull
	private String name;
	@Column(name = "phoneNo",unique = true,nullable = false)
	@javax.validation.constraints.NotNull
	private String phoneNo;
	@Column(name = "email",unique = true,nullable = false)
	@javax.validation.constraints.NotNull
	private String email;
	@Column(name = "gender",nullable = false)
	@javax.validation.constraints.NotNull
	private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Student(int id, String userName, String password, String role, @NotNull String name, @NotNull String phoneNo,
			@NotNull String email, @NotNull String gender) {
		super(id, userName, password, role);
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.gender = gender;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String userName, String password, String role) {
		super(id, userName, password, role);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", phoneNo=" + phoneNo + ", email=" + email + ", gender=" + gender + "]";
	}
	
		
	/**
	 * @param id
	 * @param userName
	 * @param password
	 * @param role
	 * @param name
	 * @param shoneNo
	 * @param email
	 */

	
	
	
	
}
	