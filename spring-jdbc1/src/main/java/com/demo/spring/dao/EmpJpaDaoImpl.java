package com.demo.spring.dao;

import java.util.List;

import com.demo.spring.entity.Emp;

//@Repository // commeneted as part of @Bean
public class EmpJpaDaoImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		String s= "JPA emp saved";
		//System.out.println("emp saved");
		return s;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
