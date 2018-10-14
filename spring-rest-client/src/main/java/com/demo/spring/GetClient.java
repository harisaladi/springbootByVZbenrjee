package com.demo.spring;


import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class GetClient {

	public static void main(String[] args) {
		
		RestTemplate rt=new RestTemplate();
		HttpHeaders hdrs=new HttpHeaders();
		
		// GET with String as response
		/*hdrs.set("Accept", "application/json");
		HttpEntity req= new HttpEntity<>(hdrs);				
		ResponseEntity<String> resp = rt.exchange("http://localhost:9090/emp?id=102",
										 HttpMethod.GET,req,String.class);		
		System.out.println(resp.getBody()); 
		
		//GET with Emp object as response
		ResponseEntity<Emp> resp1 = rt.exchange("http://localhost:9090/emp?id=102",
				 HttpMethod.GET,req,Emp.class);		
		System.out.println(resp1.getBody().getName()); 
		
		
		//GET with Emp list object as response
		ResponseEntity<List<Emp>> resp2 = rt.exchange("http://localhost:9090/emp/list",
				 HttpMethod.GET,req,new ParameterizedTypeReference<List<Emp>>() {});
		
		resp2.getBody().stream().forEach(e -> System.out.println(e.getEmpid()));*/
		
		// save object
		/*hdrs.set("Accept", "text/plain");
		hdrs.set("Content-Type", "application/json");
		Emp e= new Emp(1003,"Hari","Hyd","100000");
		HttpEntity req= new HttpEntity<>(e,hdrs);	
		
		
		ResponseEntity<String> resp3 = rt.exchange("http://localhost:9090/emp/save",
				 HttpMethod.POST,req,String.class);	
		
		System.out.println(resp3.getBody());*/
		
		// security		
		String userdetails = "shantanu:welcome1";
		String encodedCred=new String(Base64.encodeBase64(userdetails.getBytes()));
		hdrs.set("Accept", "application/json");
		hdrs.set("Authorization", "Basic "+encodedCred);
		
		HttpEntity req= new HttpEntity<>(hdrs);
		
		ResponseEntity<Emp> resp3 = rt.exchange("http://localhost:9090/emp?id=101",
				 HttpMethod.GET,req,Emp.class);	
		
		System.out.println(resp3.getBody().getName());
		
	}

}
