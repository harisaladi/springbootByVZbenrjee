package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;

@RestController
public class HrController {

	@Autowired
	HrService hrService;
	
	@GetMapping(path="/hr/emp", produces="application/json")
	public ResponseEntity<Emp> processGetEmployee(@RequestParam("id") int id){ // ResponseEntity will help us to pass headers to client who is invoking
		
		return hrService.getEmpDetails(id);
	}
	
	@GetMapping(path="/hr/list", produces="application/json")
	public ResponseEntity<List<Emp>> ProcessAllEmployees(){
		
		return hrService.getAllEmployees();
	}
}
	
