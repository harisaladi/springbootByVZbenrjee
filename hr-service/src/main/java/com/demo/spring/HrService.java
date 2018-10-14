package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

@Service
public class HrService {

	@Autowired
	RestTemplate rt;
	
	
	
	public ResponseEntity<List<Emp>> getAllEmployees(){
		
		//RestTemplate rt=new RestTemplate();
		HttpHeaders hdrs=new HttpHeaders();
		
		hdrs.set("Accept", "application/json");
		HttpEntity req= new HttpEntity<>(hdrs);	
		// before ribbon
		//ResponseEntity<List<Emp>> resp = rt.exchange("http://localhost:9092/emp/list",
		// with ribbon load balancer url will be like below, here emp-service is register name in eureka
		ResponseEntity<List<Emp>> resp = rt.exchange("http://emp-service/emp/list",
				 HttpMethod.GET,req,new ParameterizedTypeReference<List<Emp>>() {});
		
		resp.getBody().stream().forEach(e -> System.out.println(e.getEmpid()));
		
		return resp;
	}
	
	public ResponseEntity<Emp> getEmpDetails(int id){
		
		//RestTemplate rt=new RestTemplate();
		HttpHeaders hdrs=new HttpHeaders();
		
		hdrs.set("Accept", "application/json");
		HttpEntity req= new HttpEntity<>(hdrs);	
		
		//ResponseEntity<Emp> resp = rt.exchange("http://localhost:9092/emp?id=102",
		// with ribbon load balancer url will be like below, here emp-service is register name in eureka 
		ResponseEntity<Emp> resp = rt.exchange("http://emp-service/emp/"+id,
						 HttpMethod.GET,req,Emp.class);		
				System.out.println(resp.getBody().getName()); 
				
		return resp;
	}
}
