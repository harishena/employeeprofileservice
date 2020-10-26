package com.infosys.employeeprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.employeeprofile.entity.EmployeeEntity;

@Repository
public interface EmployeeProfileRepository extends JpaRepository<EmployeeEntity, Integer>{
	public EmployeeEntity findByempid(int empid);

}
