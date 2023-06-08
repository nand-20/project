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

import com.cg.oeca.dto.Appointment;
import com.cg.oeca.dto.Patient;
import com.cg.oeca.dto.Report;
import com.cg.oeca.exceptions.AppointmentIdNotFoundException;
import com.cg.oeca.exceptions.PatientIdFoundNotException;
import com.cg.oeca.service.IPatientService;
/*@RestController combines @Controller and @ResponseBody, which eliminates the need to annotate every 
 * request handling method of the controller class with the @ResponseBody annotation */
//@RequestMapping is used to map web requests onto specific handler classes and/or handler methods
@RestController
@RequestMapping("/api/patients")
public class PatientController {
	//@Autowired automatically injects the dependent beans into the associated references of a POJO class
	@Autowired
	private IPatientService PatientService;
	//Constructor
	public PatientController() {
		super();
	}
	//Parameterized constructor
	public PatientController(IPatientService patientService) {
		super();
		PatientService = patientService;
	}
	//build Add patient REST API
	@PostMapping("/addPatient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
		return new ResponseEntity<Patient>(PatientService.addPatient(patient),HttpStatus.OK);
	}
	//build get all patients REST API
	@GetMapping("/viewAllPatients")
	public List<Patient> viewPatientList() {
		return PatientService.viewPatientList();
	}
	//build get patient REST API
	@GetMapping("/viewPatientWithId/{patientId}")
	public ResponseEntity<Patient> viewPatient(@PathVariable("patientId") int patientId) throws PatientIdFoundNotException{
		return new ResponseEntity<Patient>(PatientService.viewPatient(patientId),HttpStatus.OK);
	}
	//build update patient REST API
	@PutMapping("/updatePatient")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
		return new ResponseEntity<Patient>(PatientService.updatePatient(patient),HttpStatus.OK);
	}
	//build delete patient REST API
	@DeleteMapping("/deletePatientWithId/{patientId}")
	public ResponseEntity<Patient> deletePatient(@PathVariable("patientId") int patientId) throws PatientIdFoundNotException{
		return new ResponseEntity<Patient>(PatientService.deletePatient(patientId),HttpStatus.OK);
	}
	//build book appointment REST API
	@PutMapping("/bookAppointment")
	public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment){
		return new ResponseEntity<Appointment>(PatientService.bookAppointment(appointment),HttpStatus.OK);
	}
	//build get appointment REST API
	@GetMapping("/viewAppointment/{appointmentId}")
	public ResponseEntity<Appointment> viewAppointmentDetails(@PathVariable("appointmentId") int appointmentId) throws AppointmentIdNotFoundException{
		return new ResponseEntity<Appointment>(PatientService.viewAppointmentDetails(appointmentId),HttpStatus.OK);
	}
	//build get report REST API
	@GetMapping("/viewReportWithId/{patientId}")
	public ResponseEntity<Report> viewReport(@PathVariable("patientId") int patientId) throws AppointmentIdNotFoundException{
		return new ResponseEntity<Report>(PatientService.viewReport(patientId),HttpStatus.OK);
	}
} 
