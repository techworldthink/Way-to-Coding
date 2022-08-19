package com.project.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.manager.entity.HomeManager;

@Service
public interface ManagerRepository extends JpaRepository<HomeManager, Integer>{

}
