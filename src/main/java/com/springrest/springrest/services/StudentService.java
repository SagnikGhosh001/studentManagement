package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entity.Student;

public interface StudentService {
	public List<Student> getStudents();
	public List<Student> getStudent(int studentId);
	public String updateStudent(int id,Student student);
	public void addStudent(Student student);
	public String deleteStudent(int id);
	public List<Student> getStudentBystudentEmail(String studentEmail);
	public List<Student> getStudentBystudentPhoneNo(String studentPhoneNo);
	public List<Student> getStudentBystudentUserName(String userName);
	public void forgetPassword(String email,Student passoword);
	public void changePassword(int id,Student password);
	public void changeUsername(int id,Student username);
}
