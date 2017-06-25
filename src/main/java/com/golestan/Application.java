package com.golestan;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.golestan.enums.Role;
import com.golestan.model.Course;
import com.golestan.model.Professor;
import com.golestan.model.Student;
import com.golestan.model.User;
import com.golestan.repositories.CourseRepository;
import com.golestan.repositories.ProfessorRepository;
import com.golestan.repositories.StudentRepository;

@SpringBootApplication
public class Application {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ProfessorRepository professorRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@PostConstruct
	public void init(){
		Optional<Student> studentExisted = studentRepository.findByUserName("test");
		if(!studentExisted.isPresent()){
			Student student = new Student();
			student.setFirstname("test");
			student.setLastname("test");
			student.setNationalId("0016873408");
			student.setPassword(passwordEncoder.encode("123"));
			student.setUserName("test");
			student.setRole(Role.STUDENT);
			studentRepository.save(student);
		}
		
		Optional<Professor> professorExisted = professorRepository.findByUserName("prof");
		if(!professorExisted.isPresent()){
			Professor professor = new Professor();
			professor.setFirstname("prof");
			professor.setLastname("prof");
			professor.setNationalId("0016873408");
			professor.setPassword(passwordEncoder.encode("123"));
			professor.setUserName("prof");
			professor.setRole(Role.PROFESSOR);
			professor.setGroupManager(true);
			professorRepository.save(professor);
		}
		
		Optional<Course> courseExisted = courseRepository.findByName("main");
		if(!courseExisted.isPresent()){
			Course course = new Course();
			course.setName("main");
			course.setUnit(3);
			course.setParent(null);
			courseRepository.save(course);
		}
	}
}
