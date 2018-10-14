package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
// @EnableWebSecurity -- due to spring boot this is not required, it will auto enable based on classpath jars 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource ds;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/info")
		.permitAll()
		.antMatchers("/emp/**")
		.hasAnyRole("USER","ADMIN")
		.and()
		.httpBasic()
		.and()
		.csrf()
		.disable();
		
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		//1 for in memory credentials store below is the approach, its a basic auth type
		
		/*auth.inMemoryAuthentication().withUser("hari").password("$2a$10$cSkr49jHb1fsGbxbigIMm.rRhYERZVOQ/VpFJLy/yrs/pBTu8w2JO").roles("USER");
		auth.inMemoryAuthentication().withUser("pawan").password("$2a$10$cSkr49jHb1fsGbxbigIMm.rRhYERZVOQ/VpFJLy/yrs/pBTu8w2JO").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("babu").password("$2a$10$cSkr49jHb1fsGbxbigIMm.rRhYERZVOQ/VpFJLy/yrs/pBTu8w2JO").roles("CLIENT");
		*/
		
		//1 for database credentials store below is the approach, its a type
		// here ? is user input
		auth.jdbcAuthentication().dataSource(ds)
		.usersByUsernameQuery("select username, password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, authority from authorities where username=?");
	}
	
	@Bean // this password encoder is mandatory from spring 5 or spring security 2.0.5
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
