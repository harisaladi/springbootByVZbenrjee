package com.demo.spring.service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

public class HRService {

	private EmpDao empDao;
	
	public void setEmpDao(EmpDao empDao) {
		this.empDao=empDao;
	}
	public String registerEmployee(int id, String name, String city, double salary) {
		
		String resp = empDao.save(new Emp(id,name,city,salary));
		
		return resp;
	}
}
