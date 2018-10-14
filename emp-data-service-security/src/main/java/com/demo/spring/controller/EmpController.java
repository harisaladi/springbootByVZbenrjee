package com.demo.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@RestController
public class EmpController {

	@Autowired
	private EmpRepository repo;
	
	// added for security
	@RequestMapping(path = "/info", method=RequestMethod.GET ,  produces="application/json")
	public String info() {
		return "infoooo";
	}
	
	
	@RequestMapping(path="/emp", method=RequestMethod.GET, produces="application/json")
	public Emp findById(@PathParam("id") int id) {
		//@PathVariable for path variables like /emp/104
		//@RequestParam or @PathParam for queryString values like /emp?id=104
		Optional<Emp> o= repo.findById(id);
		
		if(o.isPresent()) {
			return o.get();
		}else {
			throw new RuntimeException("no Data");
		}
		
	}
	
	@RequestMapping(path="/emp/save", method=RequestMethod.POST, consumes="application/json",produces="text/plain") 
	public String addEmp(@RequestBody Emp e) {
		
		if(repo.existsById(e.getEmpid())){
			return "emp already exists";
		}
		else {
			repo.save(e);
			return "emp saved";
		}
	}
	
	@RequestMapping(path = "/emp/update", method = RequestMethod.PUT, consumes = "application/json", produces = "text/plain") 
	public String updatedEmp(@RequestBody Emp e) {
		
		repo.save(e);
		return "updated ";
	}
	
	@RequestMapping(path = "/emp/delete", method = RequestMethod.DELETE, consumes = "application/json", produces = "text/plain") 
	public String deleteEmp(@RequestParam("id")int id) {
		
		if(repo.existsById(id)) {
		repo.deleteById(id);
		return "deleted ";
		}else {
			return " no data found to delete";
		}
	}
	@RequestMapping(path = "/emp/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Emp> getEmpList(){
		
		return repo.findAll();
	}
}
