package com.springrest.springrest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Admin;
import com.springrest.springrest.services.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/CreateAdmin")
	public ResponseEntity<HttpStatus> createAdmin(@RequestBody Admin admin){

			this.adminService.createAdmin(admin);
			return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	@PutMapping("/UpdateAdmin/{id}")
	public ResponseEntity<HttpStatus> updateAdmin(@PathVariable("id") int id,@RequestBody Admin admin){
	
			this.adminService.updateAdmin(id,admin);
			return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("/DeleteAdminById/{adminId}")
	public String deleteAdmin(@PathVariable String adminId){
		return this.adminService.deleteAdminById(Integer.parseInt(adminId));
	}
	@GetMapping("/AllAdmin")
	public List<Admin> getAllAdmin() {
		return adminService.getAllAdmin();
	}
	@GetMapping("/GetAdminById/{adminId}")
	public List<Admin> getAdminById(@PathVariable String adminId) {
		return adminService.getAdminById(Integer.parseInt(adminId));
	}
	@GetMapping("/GetAdminByEmail/{adminEmail}")
	public List<Admin> getAdminByEmail(@PathVariable String adminEmail) {
		return adminService.getAdminByEmail(adminEmail);
	}
	@GetMapping("/GetAdminByPhoneNo/{adminPhoneNo}")
	public List<Admin> getAdminByadminPhoneNo(@PathVariable String adminPhoneNo) {
		return adminService.getAdminByadminPhoneNo(adminPhoneNo);
	}
	@GetMapping("/GetAdminByUserName/{userName}")
	public List<Admin> getAdminByadminUserName(@PathVariable String userName) {
		return adminService.getAdminByadminUserName(userName);
	}
}
