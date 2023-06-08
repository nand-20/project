package com.cg.oeca.service;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.oeca.dto.Appointment;
import com.cg.oeca.exceptions.AppointmentIdNotFoundException;
import com.cg.oeca.exceptions.InvalidAppointmentException;
@Component//@Component  allows Spring to automatically detect our custom beans
public interface IAppointmentService{
	Appointment bookAppointment(Appointment appointment);
	Appointment updateAppointment(Appointment appointment)throws InvalidAppointmentException;
	Appointment cancelAppointment(int appointmentId)throws AppointmentIdNotFoundException;
	Appointment viewAppointment(int appointmentId)throws AppointmentIdNotFoundException;
	List<Appointment> viewAllAppointments();
	List<Appointment> viewAppointments(LocalDate date);
}