package com.cg.oeca.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//@Entity annotation specifies that the class is an entity and is mapped to a database table
@Entity
/*@Table annotation allows you to specify the details of the table that will be used to persist 
* the entity in the database*/
@Table(name="doctors")
public class Doctor implements Serializable{
	@Id//correspond to the primary key of the object's table
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column Specifies the mapped column for a persistent property
	@Column(name="DoctorId",nullable=false)
	private int doctorId;
	
	@Column(name="DoctorName",nullable=false)
	private String doctorName;
	
	@Column(name="DoctorConsultationTime",nullable=false)
	private String doctorConsultationTime;
	
	@Column(name="DoctorMobile",nullable=false)
	private long doctorMobile;
	
	@Column(name="DoctorEmail",nullable=false)
	private String doctorEmail;
	
	@Column(name="DoctorUsername", nullable=false)
	private String doctorUsername;
	
	@Column(name="DoctorPassword", nullable=false)
	private String doctorPassword;
	
	@Column(name="DoctorAddress")
	private String doctorAddress;
	
	@Column(name="Test")
	private Test test;
	
	@OneToMany(mappedBy="doctor",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Appointment> appointment=new ArrayList<>();
	//Constructor
	public Doctor() {	
		super();
	}	
	//Parameterized constructor
	public Doctor(int doctorId, String doctorName, String doctorConsultationTime, long doctorMobile, String doctorEmail,
			String doctorUsername, String doctorPassword, String doctorAddress,Test test,
			List<Appointment> appointment) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorConsultationTime = doctorConsultationTime;
		this.doctorMobile = doctorMobile;
		this.doctorEmail = doctorEmail;
		this.doctorUsername = doctorUsername;
		this.doctorPassword = doctorPassword;
		this.doctorAddress = doctorAddress;
		this.test = test;
		this.appointment = appointment;
	}
	//getters and setters
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorConsultationTime() {
		return doctorConsultationTime;
	}
	public void setDoctorConsultationTime(String doctorConsultationTime) {
		this.doctorConsultationTime = doctorConsultationTime;
	}
	public long getDoctorMobile() {
		return doctorMobile;
	}
	public void setDoctorMobile(long doctorMobile) {
		this.doctorMobile = doctorMobile;
	}
	public String getDoctorEmail() {
		return doctorEmail;
	}
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}
	public String getDoctorUsername() {
		return doctorUsername;
	}
	public void setDoctorUsername(String doctorUserName) {
		this.doctorUsername = doctorUserName;
	}
	public String getDoctorPassword() {
		return doctorPassword;
	}
	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}
	public String getDoctorAddress() {
		return doctorAddress;
	}
	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	
	public List<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}
	//overriding toString Method
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorConsultationTime="
				+ doctorConsultationTime + ", doctorMobile=" + doctorMobile + ", doctorEmail=" + doctorEmail
				+ ", doctorUsername=" + doctorUsername + ", doctorPassword=" + doctorPassword + ", doctorAddress="
				+ doctorAddress + ", test=" + test + ", appointment=" + appointment + "]";
	}
	
	
}
