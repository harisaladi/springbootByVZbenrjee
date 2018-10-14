package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.demo.spring")
@EnableTransactionManagement // to enable transaction
public class DaoConfig {

	@Bean("ds")
	public DriverManagerDataSource datasource() {
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springdb?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	@Bean("ds1") //assigning name for bean for further use
	public DriverManagerDataSource datasource1() {
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springdb?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	
	
	@Bean
	public DataSourceTransactionManager transactionManager(@Qualifier("ds")DataSource ds) {
					
		return new DataSourceTransactionManager(ds);
	}
	@Bean
	//public JdbcTemplate jt(DataSource ds) {
	public JdbcTemplate jt(@Qualifier("ds") DataSource ds) { // here two datasources, injecting selected datasource
		return new JdbcTemplate(ds);
		//return new JdbcTemplate(datasource1()); // if we have two datasources, this way also we can resolve like @Qualifier
	}
}
