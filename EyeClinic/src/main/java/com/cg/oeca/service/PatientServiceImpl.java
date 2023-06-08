package com.cg.oeca.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oeca.dto.Appointment;
import com.cg.oeca.dto.Patient;
import com.cg.oeca.dto.Report;
import com.cg.oeca.exceptions.AppointmentIdNotFoundException;
import com.cg.oeca.exceptions.PatientIdFoundNotException;
import com.cg.oeca.repository.IPatientRepository;
@Service//@Service annotates classes that perform service tasks
public class PatientServiceImpl implements IPatientService{
	@Autowired//@Autowired automatically injects the dependent beans into the associated references of a POJO class
	private IPatientRepository PatientRepo;
	//Constructor
	public PatientServiceImpl() {
		super();
	}
	//Parameterized constructor
	public PatientServiceImpl(IPatientRepository patientRepo) {
		super();
		PatientRepo = patientRepo;
	}
	//implementing unimplemented methods
	@Override
	public Patient addPatient(Patient patient) {
		return PatientRepo.saveAndFlush(patient);
	}
	@Override
	public Patient updatePatient(Patient patient) throws PatientIdFoundNotException {
		Patient p= PatientRepo.findById(patient.getPatientId()).orElseThrow(()->new PatientIdFoundNotException("No Patient Found with id: "+patient.getPatientId()));
		p.setPatientName(patient.getPatientName());
		p.setPatientAge(patient.getPatientAge());
		p.setPatientMobile(patient.getPatientMobile());
		p.setPatientEmail(patient.getPatientEmail());
		p.setPatientDOB(patient.getPatientDOB());
		p.setPatientUsername(patient.getPatientUsername());
		p.setPatientPassword(patient.getPatientPassword());
		p.setPatientAddress(patient.getPatientAddress());
		p.setAppointment(patient.getAppointment());
		return PatientRepo.saveAndFlush(p);
	}

	@Override
	public Patient deletePatient(int patientId) throws PatientIdFoundNotException{
		Patient p= PatientRepo.findById(patientId).orElseThrow(()->new PatientIdFoundNotException("No Patient Found with id: "+patientId));
		PatientRepo.deleteById(patientId);
		return p;
	}

	@Override
	public List<Patient> viewPatientList() {
		return PatientRepo.findAll();
	}

	@Override
	public Patient viewPatient(int patientId) throws PatientIdFoundNotException{
		Patient p= PatientRepo.findById(patientId).orElseThrow(()->new PatientIdFoundNotException("No Patient Found with id: "+patientId));
		return p;
	}
	@Override
	public Appointment bookAppointment(Appointment appointment) {
		List<Patient> patient=PatientRepo.findAll();
		for(Patient p:patient) {
			if(p.getAppointment()==null) {
				p.setAppointment(appointment);
				PatientRepo.saveAndFlush(p);
				return appointment;
			}
		}
		return null;
	}
	@Override
	public Appointment viewAppointmentDetails(int appointmentId) throws AppointmentIdNotFoundException {
		List<Patient> patient=PatientRepo.findAll();
		for(Patient p:patient) {
			if(p.getAppointment().getAppointmentId()==appointmentId) {
				return p.getAppointment();
			}
		}
		throw new AppointmentIdNotFoundException("Appointmet not found for the id: "+appointmentId);
	}
	@Override
	public Report viewReport(int patientId) throws PatientIdFoundNotException {
		
		Patient p= PatientRepo.findById(patientId).orElseThrow(()->new PatientIdFoundNotException("No Patient Found with id: "+patientId));
		return p.getReport();
	}

}
