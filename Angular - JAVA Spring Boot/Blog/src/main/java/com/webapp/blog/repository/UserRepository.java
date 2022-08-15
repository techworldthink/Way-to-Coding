package com.webapp.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.blog.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
