package com.infosys.employeeprofile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeEntity {	
	
	@Id
	@Column(name="id")
	private int empid;
	private int salary;
	private String name;
	//private String designation;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	 * public String getDesignation() { return designation; } public void
	 * setDesignation(String designation) { this.designation = designation; }
	 */
}
