package com.ashu.springBoot.crudthymeleaf.dao;

import java.util.List;

import com.ashu.springBoot.crudthymeleaf.entity.Employee;


public interface EmployeeDao {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void add(Employee employee);
	
	public void deleteById(int id);
}
