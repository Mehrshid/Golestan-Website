package com.golestan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.golestan.model.Course;
import com.golestan.model.Professor;
import com.golestan.model.Term;
import com.golestan.model.TermCourse;
import com.golestan.model.User;
import com.golestan.repositories.CourseRepository;
import com.golestan.repositories.ProfessorRepository;
import com.golestan.repositories.TermCourseRepository;
import com.golestan.repositories.TermRepository;
import com.golestan.rests.viewmodels.CourseTermVM;
import com.golestan.rests.viewmodels.CourseVM;
import com.golestan.rests.viewmodels.TermVM;
import com.golestan.security.SecurityContextHolder;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private ProfessorRepository professorRepository;
	@Autowired
	private TermRepository termRepository;
	@Autowired
	private TermCourseRepository termCourseRepository;
	
	public List<Course> getCourses(){
		
		return courseRepository.findAll();
	}
	
	@Transactional
	public void addCourse(CourseVM courseVM){
		User currentUser = SecurityContextHolder.currentUser();
		 Professor professor = professorRepository.findOne(currentUser.getId());
		if(professor != null){
				if(professor.isGroupManager()){
					Course course = new Course();
					course.setName(courseVM.getName());
					course.setUnit(courseVM.getUnit());
					if(courseVM.getParent() !=null){
						Course courseParent = courseRepository.findOne(courseVM.getParent().getId());
						course.setParent(courseParent);
					}
					courseRepository.save(course);
				}else{
					throw new RuntimeException("u are not group manager");
				}
		}else{
			throw new RuntimeException("u are not even professor");
		}
		
	}
	
	@Transactional
	public void editCourse(CourseVM courseVM){
		User currentUser = SecurityContextHolder.currentUser();
		 Professor professor = professorRepository.findOne(currentUser.getId());
		if(professor != null){
				if(professor.isGroupManager()){
					Course course =courseRepository.findOne(courseVM.getId());
					if(course != null){
						course.setName(courseVM.getName());
						course.setUnit(courseVM.getUnit());
						if(courseVM.getParent() !=null){
							Course courseParent = courseRepository.findOne(courseVM.getParent().getId());
							course.setParent(courseParent);
						}
						courseRepository.save(course);
					}else{
						throw new RuntimeException("course is not exist");
					}
				}else{
					throw new RuntimeException("u are not group manager");
				}
		}else{
			throw new RuntimeException("u are not even professor");
		}
		
	}
	
	@Transactional
	public void addCourseToTerm(CourseTermVM courseTermVM){
		CourseVM courseVM = courseTermVM.getCourseVM();
		Course course = new Course();
		course.setUnit(courseVM.getUnit());
		Course courseParent = courseRepository.findOne(courseVM.getParent().getId());
		course.setParent(courseParent);
		course.setName(courseVM.getName());
		course= courseRepository.save(course);
		
		TermVM termVM = courseTermVM.getTermVM();
		Term term = new Term();
		term.setYear(termVM.getYear());
		term.setTermNumber(termVM.getTermNumber());
		term = termRepository.save(term);
		
				
		
		TermCourse termCourse = new TermCourse();
		termCourse.setCourse(course);
		termCourse.setTerm(term);
		termCourseRepository.save(termCourse);
	}
	
}
