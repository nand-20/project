package com.cg.oeca.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oeca.dto.Appointment;
import com.cg.oeca.exceptions.AppointmentIdNotFoundException;
import com.cg.oeca.exceptions.InvalidAppointmentException;
import com.cg.oeca.repository.IAppointmentRepository;
@Service//@Service annotates classes that perform service tasks
public class AppointmentServiceImpl implements IAppointmentService{
	@Autowired//@Autowired automatically injects the dependent beans into the associated references of a POJO class
	private IAppointmentRepository AppRepo;
	//Constructor
	public AppointmentServiceImpl() {
		super();
	}
	//Parameterized constructor
	public AppointmentServiceImpl(IAppointmentRepository appRepo) {
		super();
		AppRepo = appRepo;
	}
	//implementing unimplemented methods
	@Override
	public Appointment bookAppointment(Appointment appointment) {
		return AppRepo.saveAndFlush(appointment);
	}
	
	@Override
	public Appointment updateAppointment(Appointment appointment)throws InvalidAppointmentException{
		Appointment appointment1 = AppRepo.findById(appointment.getAppointmentId()).orElseThrow(()->new InvalidAppointmentException("Invalid appointment for this Id: "+ appointment.getAppointmentId()));
		appointment1.setConsultationFee(appointment.getConsultationFee());
		appointment1.setDateOfAppointment(appointment.getDateOfAppointment());
		appointment1.setDoctor(appointment.getDoctor());
		appointment1.setPatient(appointment.getPatient());
		appointment1.setTimeOfAppointment(appointment.getTimeOfAppointment());
		return AppRepo.saveAndFlush(appointment1);
	}
	@Override
	public Appointment cancelAppointment(int appointmentId) throws AppointmentIdNotFoundException {
		Appointment appointment1 = AppRepo.findById(appointmentId).orElseThrow(()->new AppointmentIdNotFoundException("Appointment not fount for the Id: "+ appointmentId));
		AppRepo.deleteById(appointmentId);
		return appointment1;
	}
	@Override
	public Appointment viewAppointment(int appointmentId) throws AppointmentIdNotFoundException {
		return AppRepo.findById(appointmentId).orElseThrow(()->new AppointmentIdNotFoundException("Appointment not fount for the Id: "+ appointmentId));
		
	}
	@Override
	public List<Appointment> viewAllAppointments() {
		return AppRepo.findAll();
	}
	@Override
	public List<Appointment> viewAppointments(LocalDate date){
		List<Appointment> appointment = AppRepo.findAll();
		List<Appointment> list = new ArrayList<Appointment>();
		for(Appointment app:appointment) {
			if(app.getDateOfAppointment().isEqual(date)) {
				list.add(app);
			}
		}
		return list;
	}
}
