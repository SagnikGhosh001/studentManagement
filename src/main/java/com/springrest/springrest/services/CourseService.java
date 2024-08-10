package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entity.Course;

public interface CourseService {
	public List<Course> getcourses();
	public List<Course> getcourse(int courseId);
	public void addCourse(Course course);
	public void updateCourse(int id,Course course);
	public String deleteCourse(int courseId);
}
