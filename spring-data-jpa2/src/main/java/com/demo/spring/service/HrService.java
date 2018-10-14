package com.demo.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;


// it will use default bean name as class name, hrService in our case
@Service
public class HrService {

	@Autowired
	private EmpRepository repo;
	
	
	@Transactional // for jta
	public String registerEmployee(int id, String name, String city, double salary) {
		
		Emp resp = repo.save(new Emp(id,name,city,salary));
		
		return "Saved";
	}
	public void displayEmpInfo(int id) {
		
		Optional<Emp> o = repo.findById(id);
		if(o.isPresent()) {
			
			Emp emp=o.get();
			System.out.println(emp.getEmpid()+" "+emp.getName());
		}else {
			System.out.println("no data");
		}
		
		
	}
	public void getAllEmployees() {
		
		List<Emp> empList = repo.findAll();
		
		empList.stream().forEach(e -> System.out.println(e.getEmpid()+""+e.getName())); 
		
	}
	
	public void getSalRanges() {
		
		List<Emp> empList = repo.getEmpWithSalBtRange(100, 1000);
		
		empList.stream().forEach(e -> System.out.println(e.getEmpid()+""+e.getName())); 
		
	}
}
