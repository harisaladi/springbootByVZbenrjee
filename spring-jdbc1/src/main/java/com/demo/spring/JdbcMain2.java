package com.demo.spring;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.demo.spring.entity.Emp;

public class JdbcMain2 {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(DaoConfig.class);
		JdbcTemplate jt = ctx.getBean(JdbcTemplate.class);
		
		//for list of emp objects
		String query="select * from emp";
		List<Emp> empList = jt.query(query, new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new Emp(rs.getInt("EMPNO"),rs.getString("NAME"),rs.getString("ADDRESS"),rs.getDouble("SALARY"));
			}
			
			
		});
		
		empList.stream().forEach(e -> {
			System.out.println(e.getEmpid()+""+e.getName()); 
		});
		
		// for single emp object
		String query1="select * from emp where empno=1002";
		Emp e = jt.queryForObject(query1, new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new Emp(rs.getInt("EMPNO"),rs.getString("NAME"),rs.getString("ADDRESS"),rs.getDouble("SALARY"));
			}
			
			
		});
		
		System.out.println(e.getCity());
		
		

	}

}
