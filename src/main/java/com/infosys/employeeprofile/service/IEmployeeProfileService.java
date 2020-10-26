package com.infosys.employeeprofile.service;

import java.util.List;

import com.infosys.employeeprofile.config.CustomException;
import com.infosys.employeeprofile.entity.EmployeeEntity;



public interface IEmployeeProfileService {
	
	public List<EmployeeEntity> findAll();
	public EmployeeEntity findById(int empid) throws CustomException;
	public String AddEmployeeDetails(EmployeeEntity employee) throws CustomException;
	public String DeleteEmployeeDetailsById(int empid)	throws CustomException;

}
