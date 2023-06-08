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

import com.cg.oeca.dto.Report;
import com.cg.oeca.dto.Spectacles;
import com.cg.oeca.service.IReportService;
/*@RestController combines @Controller and @ResponseBody, which eliminates the need to annotate every 
 * request handling method of the controller class with the @ResponseBody annotation */
//@RequestMapping is used to map web requests onto specific handler classes and/or handler methods
@RestController
@RequestMapping("/api/reports")
public class ReportController {
	//@Autowired automatically injects the dependent beans into the associated references of a POJO class
	@Autowired
	private IReportService ReportService;
	//Constructor
	public ReportController() {
		super();
	}
	//Parameterized constructor
	public ReportController(IReportService reportService) {
		super();
		ReportService = reportService;
	}
	//build Add report REST API
	@PostMapping("/addReport")
	public ResponseEntity<Report> addReport(@RequestBody Report report){
		return new ResponseEntity<Report>(ReportService.addReport(report),HttpStatus.OK);
	}
	//build Update report REST API
	@PutMapping("/updateReport")
	public ResponseEntity<Report> updateReport(@RequestBody Report report){
		return new ResponseEntity<Report>(ReportService.updateReport(report),HttpStatus.OK);
	}
	//build Delete report REST API
	@DeleteMapping("/deleteReportWithId/{reportId}")
	public ResponseEntity<Report> removeReport(@PathVariable("reportId") int reportId){
		return new ResponseEntity<Report>(ReportService.removeReport(reportId),HttpStatus.OK);
	}
	//build get report REST API
	@GetMapping("/viewReport/{reportId}/{patientId}")
	public ResponseEntity<Report> viewReport(@PathVariable("reportId") int reportId,@PathVariable("patientId") int patientId){
		return new ResponseEntity<Report>(ReportService.viewReport(reportId,patientId),HttpStatus.OK);
	}
	//build get report with date REST API
	@GetMapping("/viewReportsWithDate/{date}")
	public List<Report> viewAllReport(@PathVariable("date") String date){
		LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return ReportService.viewAllReport(localDate);
	}
	//build get spectacles REST API
	@GetMapping("/viewSpectacles")
	public List<Spectacles> viewSpetacles(){
		return ReportService.viewSpetacles();
	}
}
