package com.cg.oeca.dto;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//@Entity annotation specifies that the class is an entity and is mapped to a database table
@Entity
/*@Table annotation allows you to specify the details of the table that will be used to persist 
 * the entity in the database*/
@Table(name="tests")
public class Test implements Serializable{
	@Id//correspond to the primary key of the object's table
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column Specifies the mapped column for a persistent property
	@Column(name="TestId",nullable=false)
	private int testId;
	@Column(name="TestName",nullable=false)
	private String testName;
	@Column(name="TestType",nullable=false)
	private String testType;
	@Column(name="TestDescription",nullable=false)
	private String testDescription;
	@Column(name="TestCost",nullable=false)
	private double testCost;
	//Constructor
	public Test() {
		super();
	}
	//Parameterized constructor
	public Test(int testId, String testName, String testType, String testDescription, double testCost) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.testType = testType;
		this.testDescription = testDescription;
		this.testCost = testCost;
	}
	//getters and setters
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public String getTestDescription() {
		return testDescription;
	}
	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}
	public double getTestCost() {
		return testCost;
	}
	public void setTestCost(double testCost) {
		this.testCost = testCost;
	}
	//overriding toString Method
	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testName=" + testName + ", testType=" + testType + ", testDescription="
				+ testDescription + ", testCost=" + testCost + "]";
	}
	
}
