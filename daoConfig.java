package com.demo.spring;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.demo.spring")
@EnableTransactionManagement // to enable transaction
@EnableJpaRepositories(basePackages="com.demo.spring.repo")
public class DaoConfig {

	@Autowired
	DataSource ds;
	
	@Bean("ds")	
	public DriverManagerDataSource datasource() {
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springdb?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	
	// for jpa
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	
		LocalContainerEntityManagerFactoryBean emfb= new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(ds); 
		emfb.setPackagesToScan("com.demo.spring.entity"); // to scan entities i.e, EMp here
		
		HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
		va.setDatabase(Database.MYSQL);
		va.setShowSql(true);
		
		emfb.setJpaVendorAdapter(va); 
		return emfb;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager jtm = new JpaTransactionManager();
		jtm.setEntityManagerFactory(emf); 
		return jtm;
		
	}
	
	// using datasouce configured in app server
	/*@Bean
	public JndiObjectFactoryBean jndi() {
		JndiObjectFactoryBean jndiBean=new JndiObjectFactoryBean();
		jndiBean.setProxyInterface(javax.sql.DataSource.class);
		jndiBean.setJndiName("jdbs/OrderDS");
		jndiBean.setResourceRef(true);
		
		return jndiBean;
	}*/
}
