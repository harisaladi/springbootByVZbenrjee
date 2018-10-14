package com.demo.spring.dao;

import com.demo.spring.entity.Emp;

public class EmpDaoImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		String s= "emp saved";
		//System.out.println("emp saved");
		return s;
	}

}
