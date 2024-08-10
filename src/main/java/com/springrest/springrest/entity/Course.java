package com.springrest.springrest.entity;



import javax.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "register_Course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "title")
	@javax.validation.constraints.NotNull
	private String title;
	
	@Column(name = "link")
	@javax.validation.constraints.NotNull
	private String link;

	public Course(int id, String title, String link) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", link=" + link + "]";
	}

	
	
}
	