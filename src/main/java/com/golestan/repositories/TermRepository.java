package com.golestan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.golestan.model.Term;

public interface TermRepository extends JpaRepository<Term, Long>{
	
}
