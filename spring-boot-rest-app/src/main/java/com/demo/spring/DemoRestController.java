package com.demo.spring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@RequestMapping(path="/greet", produces="text/plain" ,method=RequestMethod.GET )
	public String greet() {
		return "welcome";
	}
	
	@RequestMapping(path="/greet/{name}", produces="text/plain" ,method=RequestMethod.GET )
	public String greetWithName(@PathVariable("name") String n) {
		return "welcome"+n;
	}
	
	/*@RequestMapping(path="/greet1", produces="text/plain" ,method=RequestMethod.GET )
	public String greetWithQryString(@PathVariable("name") String n) {
		return "welcome"+n;
	}*/
}
