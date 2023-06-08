package com.cg.oeca.controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import com.cg.oeca.exceptions.AppointmentIdNotFoundException;
import com.cg.oeca.exceptions.InvalidAppointmentException;
import com.cg.oeca.service.IAppointmentService;
/* @RestController combines @Controller and @ResponseBody, which eliminates the need to annotate every 
 * request handling method of the controller class with the @ResponseBody annotation */
//@RequestMapping is used to map web requests onto specific handler classes and/or handler methods
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
	//@Autowired automatically injects the dependent beans into the associated references of a POJO class
	@Autowired
	private IAppointmentService AppointmentService;
	//Constructor
	public AppointmentController() {
		super();
	}
	//Parameterized constructor
	public AppointmentController(IAppointmentService appointmentService) {
		super();
		AppointmentService = appointmentService;
	}
	//build Book appointment REST API
	@PostMapping("/bookAppointment")
	public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment){
		return new ResponseEntity<Appointment>(AppointmentService.bookAppointment(appointment),HttpStatus.OK);
	}
	//build Update appointment REST API
	@PutMapping("/updateAppointment")
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) throws InvalidAppointmentException{
		return new ResponseEntity<Appointment>(AppointmentService.updateAppointment(appointment),HttpStatus.OK);
	}
	//build Delete appointment REST API
	@DeleteMapping("/cancelAppointment/{appointmentId}")
	public ResponseEntity<Appointment> cancelAppointment(@PathVariable("appointmentId") int appointmentId) throws AppointmentIdNotFoundException{
		return new ResponseEntity<Appointment>(AppointmentService.cancelAppointment(appointmentId),HttpStatus.OK);
	}
	//build get appointment REST API
	@GetMapping("/viewAppointmentWithId/{appointmentId}")
	public ResponseEntity<Appointment> viewAppointment(@PathVariable("appointmentId") int appointmentId) throws AppointmentIdNotFoundException{
		return new ResponseEntity<Appointment>(AppointmentService.viewAppointment(appointmentId),HttpStatus.OK);
	}
	//build get all appointments REST API
	@GetMapping("/viewAllAppointments")
	public List<Appointment> viewAllAppointments() {
		return AppointmentService.viewAllAppointments();
	}
	//build get appointment with date REST API
	@GetMapping("/viewAppointmentWithDate/{date}")
	public List<Appointment> viewAppointments(@PathVariable("date") String date) {
		LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return AppointmentService.viewAppointments(localDate);
	}
}
