package com.ashu.springBoot.crudthymeleaf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ashu.springBoot.crudthymeleaf.entity.Employee;



@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	//define field for entity manager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public EmployeeDaoImpl(EntityManager theEntityManager){
		entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> theQuery = 
				currentSession.createQuery("from Employee",Employee.class);
		
		//execute the query and get the result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int id) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the employee
		Employee employee = currentSession.get(Employee.class, id);
		//return employee 
		return employee;
	}

	@Override
	public void add(Employee employee) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", id);
		theQuery.executeUpdate();
		
		
	}

	

}
