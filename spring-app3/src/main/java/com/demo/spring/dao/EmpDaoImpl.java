package com.demo.spring.dao;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository 
public class EmpDaoImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		String s= "emp saved";
		//System.out.println("emp saved");
		return s;
	}

}
