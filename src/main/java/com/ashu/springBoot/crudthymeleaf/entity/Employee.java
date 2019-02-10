package com.ashu.springBoot.crudthymeleaf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	//define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column(name="id",nullable = false)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="company")
	private String company;
	
	@Column(name="address")
	private String address;
	
	//define constructor
	
	public Employee(){
		
	}

	public Employee(String name, String company, String address) {
		super();
		this.name = name;
		this.company = company;
		this.address = address;
	}
	
	//define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	//define tostring 
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", company=" + company + ", address=" + address + "]";
	}
	

}
