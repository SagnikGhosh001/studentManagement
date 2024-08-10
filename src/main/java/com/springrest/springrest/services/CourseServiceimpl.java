package com.springrest.springrest.services;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.exceptions.ResourceNotFoundException;
import com.springrest.springrest.dao.Coursedao;
import com.springrest.springrest.entity.Course;

@Service
public class CourseServiceimpl implements CourseService {
	
	@Autowired
	private Coursedao coursedao;
	@Override
	public List<Course> getcourses() {
	
		return coursedao.findAll();
	}
	@Override
	public List<Course> getcourse(int courseId) {
		coursedao.findById(courseId).orElseThrow(()->
		new ResourceNotFoundException("Course", "Id", courseId));
		return coursedao.getCourseByid(courseId);
	}
	@Override
	public void addCourse(Course course) {
		coursedao.save(course);
	}
	@Override
	public void updateCourse(int id,Course course) {
		Course existCourse=coursedao.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Course","id", id));
		existCourse.setTitle(course.getTitle());
		existCourse.setLink(course.getLink());
		coursedao.save(existCourse);
	}
	
	@Override
	public String deleteCourse(int courseId) {
		String msg=null;
		Optional<Course> opPass=coursedao.findById(courseId);
		if(opPass.isPresent()) {
			coursedao.deleteById(courseId);
			msg="Record deleted succesfully";
		}
		else {
			new ResourceNotFoundException("Course","CourseId", courseId);
		}
		return msg;
	}
}
