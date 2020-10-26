package com.infosys.employeeprofile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.employeeprofile.config.CustomException;
import com.infosys.employeeprofile.entity.EmployeeEntity;
import com.infosys.employeeprofile.repository.EmployeeProfileRepository;

@Service
public class EmployeeProfileService implements IEmployeeProfileService {
	
	@Autowired
	private EmployeeProfileRepository repository;
	
	@Override
	public List<EmployeeEntity> findAll()
	{
		List<EmployeeEntity> employee=(List<EmployeeEntity>)repository.findAll();
		return employee;
	}
	
	@Override
	public EmployeeEntity findById(int empid) throws CustomException{
		EmployeeEntity employee=(EmployeeEntity)repository.findByempid(empid);
		if(employee==null)
		{
			throw new CustomException("Employee Details are not available");
		}
		else
		return employee;
		
	}

	@Override
	public String AddEmployeeDetails(EmployeeEntity employee) throws CustomException {
		// TODO Auto-generated method stub
		String strMessage="";
		repository.save(employee);
		strMessage="Employee data has been saved";
		return strMessage;
	}

	@Override
	public String DeleteEmployeeDetailsById(int empid) throws CustomException {
		String strMessage="";
		repository.deleteById(empid);
		strMessage="Employee data has been deleted";
		return strMessage;
	}
	
	

}
