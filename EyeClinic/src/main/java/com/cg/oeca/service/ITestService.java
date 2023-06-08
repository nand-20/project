package com.cg.oeca.service;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.oeca.dto.Test;
import com.cg.oeca.exceptions.TestIdNotFoundException;
@Component//@Component  allows Spring to automatically detect our custom beans
public interface ITestService {
	Test addTest(Test test);
	Test updateTest(Test test) throws TestIdNotFoundException;
	Test removeTest(int testId) throws TestIdNotFoundException;
	Test viewTest(int testId) throws TestIdNotFoundException;
	List<Test> viewAllTests();
}
