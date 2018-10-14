package com.demo.spring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
class EmpDaoImpl implements EmpDao {
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public String save(Emp e) {		
		
				String insert_sql = "insert into EMP(empno,name,address,salary) values(?,?,?,?)";
				int count =0;
				String resp="";
				try {
				//using lambda - jdk1.8
				count = jt.update(con -> { // it will inject connection into that con variable, so we can use any name here
					// () is not required if its one argument, here con instead of (con)
					PreparedStatement pst=con.prepareStatement(insert_sql);
					pst.setInt(1, e.getEmpid());
					pst.setString(2, e.getName());
					pst.setString(3, e.getCity());
					pst.setDouble(4, e.getSalary());
					return pst;
					
				});
				resp = "successfully inserted - inserted count is"+count;
				}catch (DataAccessException ex) {
					ex.printStackTrace();
					resp= "Data notsaved";
				}
				
				//System.out.println("rows inserted: "+count);				
		return resp;
	}

	@Override
	public String delete(int id) {
		
		String delete_sql = "delete from EMP where empno=?";
		//using lambda - jdk1.8
		int count = jt.update(con -> { // it will inject connection into that con variable, so we can use any name here
			// () is not required if its one argument, here con instead of (con)
			PreparedStatement pst=con.prepareStatement(delete_sql);
			pst.setInt(1, id);			
			return pst;
			
		});
		
		
		System.out.println("rows deleted: "+count);
		return "successfully deleted - deleted count is"+count;
	}

	@Override
	public Emp findById(int id) {

				// for single emp object
				String query1="select * from emp where empno=1002";
				Emp e = jt.queryForObject(query1, new RowMapper<Emp>() {

					@Override
					public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						return new Emp(rs.getInt("EMPNO"),rs.getString("NAME"),rs.getString("ADDRESS"),rs.getDouble("SALARY"));
					}
					
					
				});
				
				return e;
	}

	@Override
	public List<Emp> getAll() {
		
				//for list of emp objects
				String query="select * from emp";
				List<Emp> empList = jt.query(query, new RowMapper<Emp>() {

					@Override
					public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						return new Emp(rs.getInt("EMPNO"),rs.getString("NAME"),rs.getString("ADDRESS"),rs.getDouble("SALARY"));
					}
					
					
				});
								
				return empList;
	}

}
