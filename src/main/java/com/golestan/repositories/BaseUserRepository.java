package com.golestan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.golestan.model.User;

@NoRepositoryBean
public interface BaseUserRepository<T extends User> extends  JpaRepository<T, Long>{
}
