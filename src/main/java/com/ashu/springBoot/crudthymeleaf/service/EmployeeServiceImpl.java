package com.ashu.springBoot.crudthymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashu.springBoot.crudthymeleaf.dao.EmployeeDao;
import com.ashu.springBoot.crudthymeleaf.entity.Employee;



@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDao empDao;

	@Autowired
	public EmployeeServiceImpl(EmployeeDao theEmpDao){
		this.empDao = theEmpDao;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return empDao.findById(id);
	}

	@Override
	@Transactional
	public void add(Employee employee) {
		// TODO Auto-generated method stub
		empDao.add(employee);
		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		empDao.deleteById(id);
	}

}
