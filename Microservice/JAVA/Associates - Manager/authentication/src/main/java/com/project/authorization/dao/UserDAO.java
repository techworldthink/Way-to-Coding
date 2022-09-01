package com.project.authorization.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.authorization.model.UserData;

@Repository
public interface UserDAO extends JpaRepository<UserData, String> {

}
