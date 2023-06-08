package com.cg.oeca.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oeca.dto.Test;
import com.cg.oeca.exceptions.TestIdNotFoundException;
import com.cg.oeca.repository.ITestRepository;
@Service//@Service annotates classes that perform service tasks
public class TestServiceImpl implements ITestService{
	@Autowired//@Autowired automatically injects the dependent beans into the associated references of a POJO class
	private ITestRepository TestRepo;
	//Constructor
	public TestServiceImpl() {
		super();
	}
	//Parameterized constructor
	public TestServiceImpl(ITestRepository testRepo) {
		super();
		TestRepo = testRepo;
	}
	//implementing unimplemented methods
	@Override
	public Test addTest(Test test) {
		return TestRepo.saveAndFlush(test);
	}
	@Override
	public Test updateTest(Test test) throws TestIdNotFoundException{
		Test t1= TestRepo.findById(test.getTestId()).orElseThrow(()->new TestIdNotFoundException("Test not found for the Id: "+ test.getTestId()));
		t1.setTestName(test.getTestName());		
		t1.setTestType(test.getTestType());
		t1.setTestDescription(test.getTestDescription());
		t1.setTestCost(test.getTestCost());
		return TestRepo.saveAndFlush(t1);
	}
	@Override
	public Test removeTest(int testId) throws TestIdNotFoundException {
		Test test= TestRepo.findById(testId).orElseThrow(()->new TestIdNotFoundException("Test not found for the Id: "+ testId));
		TestRepo.deleteById(testId);
		return test;
	}
	@Override
	public Test viewTest(int testId) throws TestIdNotFoundException {
		Test Test = TestRepo.findById(testId).orElseThrow(()->new TestIdNotFoundException("Test not found for the Id: "+ testId));
		return Test;
	}
	@Override
	public List<Test> viewAllTests() {
		return TestRepo.findAll();
	}
	
}
