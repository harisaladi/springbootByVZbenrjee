package com.demo.spring;

import java.util.ArrayList;
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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HrService {

	@Autowired
	RestTemplate rt;
	
	
	@HystrixCommand(fallbackMethod="getEmpFallack")
	public ResponseEntity<List<Emp>> getAllEmployees(){
		
		
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
	
	public ResponseEntity<List<Emp>> getEmpFallack(){
		
		List<Emp> listEmp = new ArrayList<Emp>();
		listEmp.add(new Emp());
		return ResponseEntity.ok(listEmp);
		
		//return resp;
	}
	
	public ResponseEntity<Emp> getEmpDetails(int id){
		
		
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
