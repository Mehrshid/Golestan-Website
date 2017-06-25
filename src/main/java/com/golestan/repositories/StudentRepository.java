package com.golestan.repositories;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.golestan.model.Student;
import com.golestan.model.User;

@Transactional
public interface StudentRepository extends BaseUserRepository<Student> {
	Optional<Student> findByUserName(String userName);
}
