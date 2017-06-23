package com.golestan.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long Id;
	
	private String name ;
	
	private int unit;
	
	private String courseGroup;
	
	@ManyToOne
	private Course parent;
	
	@OneToMany
	private List<Course> children;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public String getCourseGroup() {
		return courseGroup;
	}

	public void setCourseGroup(String courseGroup) {
		this.courseGroup = courseGroup;
	}

	public Course getParent() {
		return parent;
	}

	public void setParent(Course parent) {
		this.parent = parent;
	}

	public List<Course> getChildren() {
		return children;
	}

	public void setChildren(List<Course> children) {
		this.children = children;
	}

	
	
	
}
