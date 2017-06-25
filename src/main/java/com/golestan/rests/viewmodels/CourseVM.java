package com.golestan.rests.viewmodels;


public class CourseVM {

	private String name ;

	private int unit;
	
	private String courseGroup;
	
	private CourseVM parent;
	
	private long id;

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

	public CourseVM getParent() {
		return parent;
	}

	public void setParent(CourseVM parent) {
		this.parent = parent;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
