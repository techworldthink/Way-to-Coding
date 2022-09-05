package com.project.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.manager.entity.AssignManagers;

@Repository
public interface AssignedRepository extends JpaRepository<AssignManagers, Integer> {

	boolean existsByEmployeeId(int associateId);

}
