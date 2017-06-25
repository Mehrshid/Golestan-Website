package com.golestan.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.golestan.model.Course;
public interface CourseRepository extends JpaRepository<Course, Long> {
	Optional<Course> findByName(String name);
}
