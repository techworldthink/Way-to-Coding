package com.collateral.loans.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collateral.loans.model.UserData;

@Repository
public interface UserDAO extends JpaRepository<UserData, String> {

}
