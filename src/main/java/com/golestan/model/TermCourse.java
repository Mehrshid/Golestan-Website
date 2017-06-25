package com.golestan.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity(name = "golestan_term_course")
public class TermCourse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long Id;
	
	@ManyToOne
	private Term term;
	
	@ManyToOne
	private Course course;
	
	@ManyToOne
	private Professor professor;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
	
	
}
