package com.springrest.springrest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springrest.springrest.entity.Course;

public interface Coursedao extends JpaRepository<Course, Integer> {
	
	@Query("select c from Course c where c.id=?1")
	List<Course> getCourseByid(long id);
	Optional<Course> findByTitle(String title);
	
}
