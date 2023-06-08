package com.cg.oeca.service;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.oeca.dto.Appointment;
import com.cg.oeca.dto.Doctor;
import com.cg.oeca.dto.Test;
import com.cg.oeca.exceptions.DoctorIdNotFoundException;
@Component//@Component  allows Spring to automatically detect our custom beans
public interface IDoctorService {
	Doctor addDoctor(Doctor doctor);
	Doctor updateDoctor(Doctor doctor) throws DoctorIdNotFoundException;
	Doctor deleteDoctor(int doctorId) throws DoctorIdNotFoundException;
	Doctor viewDoctor(int doctorId) throws DoctorIdNotFoundException;
	List<Doctor> viewDoctorsList();
	List<Appointment> viewAppointments();
	Test createTest(int doctorId,Test test);
}
