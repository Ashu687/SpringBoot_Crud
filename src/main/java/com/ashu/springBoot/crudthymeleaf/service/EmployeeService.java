package com.ashu.springBoot.crudthymeleaf.service;

import java.util.List;

import com.ashu.springBoot.crudthymeleaf.entity.Employee;



public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int id);

	public void add(Employee employee);

	public void deleteById(int id);

}
