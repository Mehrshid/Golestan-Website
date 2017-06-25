package com.golestan.rests.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.golestan.rests.viewmodels.CourseTermVM;
import com.golestan.rests.viewmodels.CourseVM;
import com.golestan.service.CourseService;

@RestController
@RequestMapping("${api.base.url}"+"/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@PostMapping
	public ResponseEntity<?> addCourse(@Validated @RequestBody CourseVM courseVM){
		courseService.addCourse(courseVM);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@PutMapping
	public ResponseEntity<?> editCourse(@Validated @RequestBody CourseVM courseVM){
		courseService.editCourse(courseVM);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> getCourses(){
		return new ResponseEntity<>(courseService.getCourses(),HttpStatus.OK);
	}
	
	@PostMapping("/add-to-term")
	public ResponseEntity<?> addCourseToTerm(@Validated @RequestBody CourseTermVM courseTermVM){
			courseService.addCourseToTerm(courseTermVM);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/*@PostMapping
	public ResponseEntity<?> addCourseForStudent(){
		
	}*/
}
