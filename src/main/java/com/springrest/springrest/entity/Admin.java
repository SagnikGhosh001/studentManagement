package com.springrest.springrest.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name = "Register_Admin")
public class Admin extends User {
	    @Column(name = "name",length = 50,nullable = false)
		private String name;
		
		
	    @Column(name="email",length = 100,unique = true,nullable = false)
		private String email;
		
	    @Column(name="phoneNo",length = 100,unique = true,nullable = false)
		private String phoneNo;
	    
	    @Column(name="gender",nullable = false)
	    private String gender;
	    /**
		 * @param id
		 * @param userName
		 * @param password
		 * @param role
		 * @param name
		 * @param email
		 * @param phoneNo
		 */

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public Admin(int id, String userName, String password, String role, String name, String email, String phoneNo,
				String gender) {
			super(id, userName, password, role);
			this.name = name;
			this.email = email;
			this.phoneNo = phoneNo;
			this.gender = gender;
		}

		public Admin() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Admin(int id, String userName, String password, String role) {
			super(id, userName, password, role);
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Admin [name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", gender=" + gender + "]";
		}

		
		

		
		
}
