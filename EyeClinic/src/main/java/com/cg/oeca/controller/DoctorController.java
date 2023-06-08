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
import com.cg.oeca.dto.Doctor;
import com.cg.oeca.dto.Test;
import com.cg.oeca.exceptions.DoctorIdNotFoundException;
import com.cg.oeca.service.IDoctorService;
/*@RestController combines @Controller and @ResponseBody, which eliminates the need to annotate every 
 * request handling method of the controller class with the @ResponseBody annotation */
//@RequestMapping is used to map web requests onto specific handler classes and/or handler methods
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
	//@Autowired automatically injects the dependent beans into the associated references of a POJO class
	@Autowired
	private IDoctorService DoctorService;
	//Constructor
	public DoctorController() {
		super();
	}
	//Parameterized constructor
	public DoctorController(IDoctorService doctorService) {
		super();
		DoctorService = doctorService;
	}
	//build Add doctor REST API
    @PostMapping("/addDoctor")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(DoctorService.addDoctor(doctor),HttpStatus.OK);
	}
    //build Update doctor REST API
    @PutMapping("/updateDoctor")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor)throws DoctorIdNotFoundException{
		return new ResponseEntity<Doctor>(DoctorService.updateDoctor(doctor),HttpStatus.OK);
	}
    //build Delete doctor REST API
    @DeleteMapping("/deleteDoctorWithId/{doctorId}")
	public ResponseEntity<Doctor> deleteDoctor(@PathVariable("doctorId") int doctorId) throws DoctorIdNotFoundException{
		return new ResponseEntity<Doctor>(DoctorService.deleteDoctor(doctorId),HttpStatus.OK);
	}
    //build Get doctor REST API
    @GetMapping("/viewDoctorWithId/{doctorId}")
	public ResponseEntity<Doctor> viewDoctor(@PathVariable("doctorId") int doctorId) throws DoctorIdNotFoundException{
		return new ResponseEntity<Doctor>(DoctorService.viewDoctor(doctorId),HttpStatus.OK);
	}
    //build get all doctors REST API
    @GetMapping("/viewAllDoctors")
	public List<Doctor> viewDoctorsList() {
		return DoctorService.viewDoctorsList();
	}
    //build get appointments REST API
    @GetMapping("/viewAllAppointments")
	public List<Appointment> viewAppointments(){
		return DoctorService.viewAppointments();
	}
    //build create test REST API
    @PutMapping("/createTest/{doctorId}")
    public ResponseEntity<Test> createTest(@PathVariable("doctorId") int doctorId,@RequestBody Test test){
		return new ResponseEntity<Test>(DoctorService.createTest(doctorId,test),HttpStatus.OK);
	}
}
