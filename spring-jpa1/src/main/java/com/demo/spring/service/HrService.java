package com.demo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;


// it will use default bean name as class name, hrService in our case
@Service
public class HrService {

	@Autowired
	
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
	public void getAllEmployees() {
		
		List<Emp> empList = empDao.getAll();
		
		empList.stream().forEach(e -> System.out.println(e.getEmpid()+""+e.getName())); 
		
	}
}
