package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entity.Admin;

public interface AdminService {
	public List<Admin> getAllAdmin();
	public List<Admin> getAdminById(int id);
	public List<Admin> getAdminByEmail(String adminEmail);
	public List<Admin> getAdminByadminPhoneNo(String adminPhoneNo);
	public List<Admin> getAdminByadminUserName(String userName);
	public void createAdmin(Admin admin);
	public void updateAdmin(int id,Admin admin);
	public String deleteAdminById(int id);
	
	
}
