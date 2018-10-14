package com.demo.spring.entity;

public class Emp {
	
	
	private int empid;
	
	
	private String name;
	
	
	private String city;
	
	
	private String salary;
	
	
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
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Emp(int empid, String name, String city, String salary) {
		super();
		this.empid = empid;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
