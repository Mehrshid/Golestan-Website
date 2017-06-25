package com.golestan.repositories;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.golestan.model.Professor;
import com.golestan.model.User;

@Transactional
public interface ProfessorRepository extends BaseUserRepository<Professor>{

	Optional<Professor> findByUserName(String userName);
}
