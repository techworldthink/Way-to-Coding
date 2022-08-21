package com.project.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.manager.entity.AssignManagers;

@Service
public interface AssignedRepository extends JpaRepository<AssignManagers, Integer> {

	boolean existsByAssociateId(int associateId);

}
