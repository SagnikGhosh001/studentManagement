package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Course;
import com.springrest.springrest.services.CourseService;
@RestController
@RequestMapping("/course")
public class MyCourseController {
	
	@Autowired
	CourseService obj_CourseService;
	
	@GetMapping("/Home")
	public String home(){
		return "Welcome to student management system";
	}
	
	//get courses
	@GetMapping("/AllCourses")
	public List<Course> getcourses(){
		return obj_CourseService.getcourses();
	}
	
	//get single course
	@GetMapping("/CourseById/{courseId}")
	public List<Course> getcourse(@PathVariable String courseId) {
		return obj_CourseService.getcourse(Integer.parseInt(courseId));
	}
	
	//add Single course
	@PostMapping("/AddCourse/{role}")
	public ResponseEntity<?> addCourse(@PathVariable("role") String role,@RequestBody Course course) {
		if(role.equals("admin")) {
			this.obj_CourseService.addCourse(course);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("You are not Admin",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/UpdateCourses/{id}/{role}")
	public ResponseEntity<?> updateCourse(@PathVariable("role") String role,@PathVariable("id") int id,@RequestBody Course course) {
		if(role.equals("admin")) {
			this.obj_CourseService.updateCourse(id,course);
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("You are not admin",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/DeleteCourses/{courseId}/{role}")
	public ResponseEntity<?> deleteCourse(@PathVariable("role") String role,@PathVariable String courseId) {
		if(role.equals("admin")) {
			this.obj_CourseService.deleteCourse(Integer.parseInt(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("Your are not admin",HttpStatus.BAD_REQUEST);
		}
	}
}
