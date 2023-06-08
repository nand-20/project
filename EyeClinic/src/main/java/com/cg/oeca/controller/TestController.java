package com.cg.oeca.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oeca.dto.Test;
import com.cg.oeca.exceptions.TestIdNotFoundException;
import com.cg.oeca.service.ITestService;
/*@RestController combines @Controller and @ResponseBody, which eliminates the need to annotate every 
 * request handling method of the controller class with the @ResponseBody annotation */
//@RequestMapping is used to map web requests onto specific handler classes and/or handler methods
@RestController
@RequestMapping("/api/tests")
public class TestController {
	//@Autowired automatically injects the dependent beans into the associated references of a POJO class
	@Autowired
	private ITestService TestService;
	//Constructor
	public TestController() {
		super();
	}
	//Parameterized constructor
	public TestController(ITestService testService) {
		super();
		TestService = testService;
	}
	//build Add test REST API
    @PostMapping("/addTest")
	public ResponseEntity<Test> addTest(@RequestBody Test test){
		return new ResponseEntity<Test>(TestService.addTest(test),HttpStatus.OK);
	}
	
	//build Update test REST API
    @PutMapping("/updateTest")
	public ResponseEntity<Test> updateTest(@RequestBody Test test) throws TestIdNotFoundException{
   	return new ResponseEntity<Test>(TestService.updateTest(test),HttpStatus.OK);
	}
    
    //build Delete test REST API
    @DeleteMapping("/deleteTest/{testId}")
	public ResponseEntity<Test> removeTest(@PathVariable("testId") int testId) throws TestIdNotFoundException{
		return new ResponseEntity<Test>(TestService.removeTest(testId),HttpStatus.OK);
	}
    //build get test REST API
    @GetMapping("/viewTestWithId/{testId}")
	public ResponseEntity<Test> viewTest(@PathVariable("testId") int testId) throws TestIdNotFoundException{
		return new ResponseEntity<Test>(TestService.viewTest(testId),HttpStatus.OK);
	}	 
    //build get all tests REST API
    @GetMapping("/viewAllTests")
	public List<Test> viewAllTests(){
		return TestService.viewAllTests();
	}
}
