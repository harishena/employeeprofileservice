package com.infosys.employeeprofile.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.employeeprofile.config.CustomException;
import com.infosys.employeeprofile.entity.EmployeeEntity;
import com.infosys.employeeprofile.service.IEmployeeProfileService;

@RestController
public class EmployeeProfileController {
	
	@Autowired
	IEmployeeProfileService profileService;
	
	@GetMapping("/employee")
	@ResponseBody
	public List<EmployeeEntity> getEmployeeDetails(){
	List<EmployeeEntity> employeeDetails=(List<EmployeeEntity>)	profileService.findAll();
	return employeeDetails;
	}
	
	@GetMapping(value="/employee/id")
	@ResponseBody
	//http://localhost:8082/employee/id?empid=1
	public EmployeeEntity getEmployeeDetailsById(@RequestParam("empid") int empid) throws CustomException
	{
		EmployeeEntity employee=(EmployeeEntity) profileService.findById(empid);
		return employee;
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<?> createUser(@Valid @RequestBody Map<String,Object> user)
	{
		
		 // using for-each loop for iteration over Map.entrySet() 
        for (Map.Entry<String,Object> entry : user.entrySet())  {
        	
        	if(entry.getValue() instanceof String) {
        	
        		System.out.println("Key = " + entry.getKey() + ", Value = " +entry.getValue());
    			         		
        	}else if(entry.getValue() instanceof List) {
        		System.out.println("entry List->>>>>>>>>"+(Object )entry);
        		System.out.println("List Main key->>>>>>>>>"+entry.getKey());
        		System.out.println("List of Objects->>>>>>>>>"+entry.getValue());
				/*
				 * List<Map<String,String>> list=(List)entry.getValue();
				 * Iterator<Map<String,String>> itr=list.iterator();
				 * 
				 * while(itr.hasNext()) { Map<String,String> map=(Map)itr.next();
				 * 
				 * for (Map.Entry<String,String> entry2 : map.entrySet()) {
				 * System.out.println("Key = " + entry2.getKey() + ", Value = "
				 * +entry2.getValue()); }
				 * 
				 * }
				 */		
        		
        	}else if(entry.getValue() instanceof Map) {
        		System.out.println("Map Main key->>>>>>>>>"+entry.getKey());
        		System.out.println("Map Key,Value pairs->>>>>>>>>"+entry.getValue());
				
				  Map<String,String> map3=(Map)entry.getValue();
				  
				  for (Map.Entry<String,String> entry3 : map3.entrySet()) {
				  System.out.println("Key = " + entry3.getKey() + ", Value = "
				  +entry3.getValue()); 
				  if(map3.containsKey("eventID")) {
					  System.out.println("eventID value>>>>> "+entry3.getValue());
					  Object eventID= entry3.getValue();
					  System.out.println("Object eventID value>>>>"+eventID);
				  
				  }
				  }
				 
        		
        	}
        	
        	
        	
			
	}	  
		 
		return null;
	}
	
	

	
	

}
