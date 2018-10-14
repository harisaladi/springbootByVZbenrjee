package com.demo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;


// it will use default bean name as class name, hrService in our case
@Service
public class HrService {

	@Autowired
	//@Qualifier("jpaDao") // this is for @Bean
	//@Qualifier("empJpaDaoImpl")
	// this qualier for only required impl for inject, otherwise we will get exception, becoz we have two impl classes, 
	//which one need to inject spring dont know so, qualifier will fullfill this issue
	private EmpDao empDao;
	
	// not required setter here
	/*public void setEmpDao(EmpDao empDao) {
		this.empDao=empDao;
	}*/
	@Transactional // for jta
	public String registerEmployee(int id, String name, String city, double salary) {
		
		String resp = empDao.save(new Emp(id,name,city,salary));
		
		return resp;
	}
	public void displayEmpInfo(int id) {
		
		Emp emp = empDao.findById(id);
		
		System.out.println(emp.getEmpid()+" "+emp.getName());
	}
}
