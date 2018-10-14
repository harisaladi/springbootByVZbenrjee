package com.demo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMP")
public class Emp {

	@Id
	@Column(name="EMPNO")
	private int empid;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String city;
	
	@Column(name="SALARY") // if column name and property name is same then @column mapping not required
	private double salary;
	
	public Emp() {
		
	}

	public Emp(int empid, String name, String city, double salary) {
		super();
		this.empid = empid;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
