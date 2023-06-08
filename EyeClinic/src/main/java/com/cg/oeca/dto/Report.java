package com.cg.oeca.dto;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//@Entity annotation specifies that the class is an entity and is mapped to a database table
@Entity
/*@Table annotation allows you to specify the details of the table that will be used to persist 
* the entity in the database*/
@Table(name="reports")
public class Report implements Serializable{
	@Id//correspond to the primary key of the object's table
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column Specifies the mapped column for a persistent property
	@Column(name="ReportId",nullable=false)
	private int reportId;
	@DateTimeFormat(style = "yyyy-MM-dd")
	@Column(name="DateOfReport",nullable=false)
	private LocalDate dateOfReport;
	@Column(name="DescriptionOfReport",nullable=false)
	private String descriptionOfReport;
	@Column(name="VisualAcuity",nullable=false)
	private String visualAcuity;
	@Column(name="VisualAcuityForNear",nullable=false)
	private String visualAcuityForNear;
	@Column(name="VisualAcuityForDistance",nullable=false)
	private String visualAcuityForDistance;
	@Column(name="Spectacles")
	private Spectacles spectacles;
	@JsonIgnoreProperties("report")//ignores the property 
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "patientId", referencedColumnName ="patientId")
	private Patient patient;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "typeOfTest", referencedColumnName = "testType")
	private Test test;
	//Constructor
	public Report() {
		super();
	}
	//Parameterized constructor
	public Report(int reportId, LocalDate dateOfReport, String descriptionOfReport, String visualAcuity,
			String visualAcuityForNear, String visualAcuityForDistance, Patient patient, Test test,
			Spectacles spectacles) {
		super();
		this.reportId = reportId;
		this.dateOfReport = dateOfReport;
		this.descriptionOfReport = descriptionOfReport;
		this.visualAcuity = visualAcuity;
		this.visualAcuityForNear = visualAcuityForNear;
		this.visualAcuityForDistance = visualAcuityForDistance;
		this.patient = patient;
		this.test = test;
		this.spectacles = spectacles;
	}
	//getters and setters
	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public LocalDate getDateOfReport() {
		return dateOfReport;
	}

	public void setDateOfReport(LocalDate dateOfReport) {
		this.dateOfReport = dateOfReport;
	}

	public String getDescriptionOfReport() {
		return descriptionOfReport;
	}

	public void setDescriptionOfReport(String descriptionOfReport) {
		this.descriptionOfReport = descriptionOfReport;
	}

	public String getVisualAcuity() {
		return visualAcuity;
	}

	public void setVisualAcuity(String visualAcuity) {
		this.visualAcuity = visualAcuity;
	}

	public String getVisualAcuityForNear() {
		return visualAcuityForNear;
	}

	public void setVisualAcuityForNear(String visualAcuityForNear) {
		this.visualAcuityForNear = visualAcuityForNear;
	}

	public String getVisualAcuityForDistance() {
		return visualAcuityForDistance;
	}

	public void setVisualAcuityForDistance(String visualAcuityForDistance) {
		this.visualAcuityForDistance = visualAcuityForDistance;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Spectacles getSpectacles() {
		return spectacles;
	}

	public void setSpectacles(Spectacles spectacles) {
		this.spectacles = spectacles;
	}
	//overriding toString Method
	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", dateOfReport=" + dateOfReport + ", descriptionOfReport="
				+ descriptionOfReport + ", visualAcuity=" + visualAcuity + ", visualAcuityForNear="
				+ visualAcuityForNear + ", visualAcuityForDistance=" + visualAcuityForDistance + ", patient=" + patient
				+ ", test=" + test + ", spectacle=" + spectacles + "]";
	}
	
	
}
