package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class JdbcMain1 {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(DaoConfig.class);
		JdbcTemplate jt = ctx.getBean(JdbcTemplate.class);
		
		String insert_sql = "insert into EMP(empno,name,address,salary) values(?,?,?,?)";
		
		// using existing java1.7
		int count = jt.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement pst=con.prepareStatement(insert_sql);
				pst.setInt(1, 1007);
				pst.setString(2, "myname");
				pst.setString(3, "myaddress");
				pst.setDouble(4, 1000);
				return pst;
			}
		});
		
		//using lambda - jdk1.8
		int count1 = jt.update(con -> { // it will inject connection into that con variable, so we can use any name here
			// () is not required if its one argument, here con instead of (con)
			PreparedStatement pst=con.prepareStatement(insert_sql);
			pst.setInt(1, 1008);
			pst.setString(2, "myname");
			pst.setString(3, "myaddress");
			pst.setDouble(4, 1000);
			return pst;
			
		});
		
		
		System.out.println("rows inserted: "+count);
		System.out.println("rows inserted: "+count1);

	}

}
