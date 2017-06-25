package com.golestan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="golestan_stu_te_co_te")
public class StudentTermCourse {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long Id;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private TermCourse termCourse;
	
	private String grade;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	public TermCourse getTermCourse() {
		return termCourse;
	}

	public void setTermCourse(TermCourse termCourse) {
		this.termCourse = termCourse;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
