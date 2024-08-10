package com.springrest.springrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.exceptions.ResourceNotFoundException;
import com.springrest.springrest.dao.Admindao;
import com.springrest.springrest.entity.Admin;

@Service
public class AdminServiceimpl implements AdminService {

	@Autowired
	Admindao adminDao;
	
	@Override
	public List<Admin> getAllAdmin() {
		return adminDao.findAll();
	}

	@Override
	public List<Admin> getAdminById(int id) {
		adminDao.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Admin","Id",id));
		return  adminDao.getById(id);
	}

	@Override
	public void createAdmin(Admin admin) {
		adminDao.save(admin);
		
	}

	@Override
	public void updateAdmin(int id,Admin admin) {
		Admin existadmin=adminDao.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Admin", "id", id));
		existadmin.setEmail(admin.getEmail());
		existadmin.setName(admin.getName());
		existadmin.setPhoneNo(admin.getPhoneNo());
		existadmin.setPassword(admin.getPassword());
		existadmin.setRole(admin.getRole());
		existadmin.setUserName(admin.getUserName());
		existadmin.setGender(admin.getGender());
		adminDao.save(existadmin);
		
	}

	@Override
	public String deleteAdminById(int id) {
		String msg=null;
		Optional<Admin> opPass=adminDao.findById(id);
		if(opPass.isPresent()) {
		adminDao.deleteById(id);
		msg="Record deleted Succesfully";
		}
		else {
			throw new ResourceNotFoundException("Admin","id",id);
		}
		return msg;
		
	}

	@Override
	public List<Admin> getAdminByEmail(String adminEmail) {
		adminDao.findByEmail(adminEmail).orElseThrow(()->
		new ResourceNotFoundException("Admin", "adminEmail", adminEmail));
		return adminDao.getByAdminEmail(adminEmail);
	}

	@Override
	public List<Admin> getAdminByadminPhoneNo(String adminPhoneNo) {
		adminDao.findByPhoneNo(adminPhoneNo).orElseThrow(()->
		new ResourceNotFoundException("Admin", "PhoneNo", adminPhoneNo));
		return adminDao.getByAdminPhoneNo(adminPhoneNo);
	}

	@Override
	public List<Admin> getAdminByadminUserName(String userName) {
		adminDao.findByUserName(userName).orElseThrow(()->
		new ResourceNotFoundException("Admin", "userName", userName));
		return adminDao.getByUserName(userName);
	}

	


}
