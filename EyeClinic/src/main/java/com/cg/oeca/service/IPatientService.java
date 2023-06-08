package com.cg.oeca.service;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.oeca.dto.Appointment;
import com.cg.oeca.dto.Patient;
import com.cg.oeca.dto.Report;
import com.cg.oeca.exceptions.AppointmentIdNotFoundException;
import com.cg.oeca.exceptions.PatientIdFoundNotException;
@Component//@Component  allows Spring to automatically detect our custom beans
public interface IPatientService {
	Patient addPatient(Patient patient);
	Patient updatePatient(Patient patient);
	Patient deletePatient(int patientId) throws PatientIdFoundNotException;
	List<Patient> viewPatientList();
	Patient viewPatient(int patientId) throws PatientIdFoundNotException;
	Appointment bookAppointment(Appointment appointment);
	Appointment viewAppointmentDetails(int appointmentid)throws AppointmentIdNotFoundException;
	Report viewReport(int patientId)throws PatientIdFoundNotException;
}