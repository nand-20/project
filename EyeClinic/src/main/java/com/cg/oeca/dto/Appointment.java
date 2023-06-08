package com.cg.oeca.dto;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//@Entity annotation specifies that the class is an entity and is mapped to a database table
@Entity
/*@Table annotation allows you to specify the details of the table that will be used to persist 
* the entity in the database*/
@Table(name="appointments")
public class Appointment implements Serializable{
	@Id//correspond to the primary key of the object's table
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column Specifies the mapped column for a persistent property
	@Column(name="AppointmentId", nullable=false)
	private int appointmentId;
	
	@DateTimeFormat(style = "yyyy-MM-dd")
	@Column(name="DateOfAppointment", nullable=false)
	private LocalDate dateOfAppointment;
	
	@DateTimeFormat(style = "HH:mm")
	@Column(name="TimeOfAppointment", nullable=false)
	private LocalTime timeOfAppointment;
	
	@Column(name="ConsultationFee", nullable=false)
	private double consultationFee;
	
	@ManyToOne
	@JoinColumn(name="doctorId",referencedColumnName ="doctorId")	
	private Doctor doctor;
	
	@OneToOne(mappedBy="appointment")
	@JsonIgnoreProperties("appointment")//ignores the property 
	@JoinColumn(name = "patientId", referencedColumnName ="patientId")
	private Patient patient;
	
	//Constructor
	public Appointment() {
		super();
	}
	//Parameterized constructor
	public Appointment(int appointmentId, LocalDate dateOfAppointment, LocalTime timeOfAppointment,
			double consultationFee, Doctor doctor, Patient patient) {
		super();
		this.appointmentId = appointmentId;
		this.dateOfAppointment = dateOfAppointment;
		this.timeOfAppointment = timeOfAppointment;
		this.consultationFee = consultationFee;
		this.doctor = doctor;
		this.patient = patient;
	}
	//getters and setters
	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(LocalDate dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public LocalTime getTimeOfAppointment() {
		return timeOfAppointment;
	}

	public void setTimeOfAppointment(LocalTime timeOfAppointment) {
		this.timeOfAppointment = timeOfAppointment;
	}

	public double getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	//overriding toString Method
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", dateOfAppointment=" + dateOfAppointment
				+ ", timeOfAppointment=" + timeOfAppointment + ", consultationFee=" + consultationFee + ", doctor="
				+ doctor + ", patient=" + patient + "]";
	}
	
	
}