package com.cg.oeca.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oeca.dto.Appointment;
import com.cg.oeca.dto.Doctor;
import com.cg.oeca.dto.Test;
import com.cg.oeca.exceptions.DoctorIdNotFoundException;
import com.cg.oeca.repository.IDoctorRepository;
@Service//@Service annotates classes that perform service tasks
public class DoctorServiceImpl implements IDoctorService{
	@Autowired//@Autowired automatically injects the dependent beans into the associated references of a POJO class
	private IDoctorRepository DocRepo;
	//Constructor
	public DoctorServiceImpl() {
		super();
	}	
	//Parameterized constructor
	public DoctorServiceImpl(IDoctorRepository docRepo) {
		super();
		DocRepo = docRepo;
	}
	//implementing unimplemented methods
	@Override
	public Doctor addDoctor(Doctor doctor) {
		return DocRepo.saveAndFlush(doctor);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor)  throws DoctorIdNotFoundException{
		Doctor d =DocRepo.findById(doctor.getDoctorId()).orElseThrow(()->new DoctorIdNotFoundException("Invalid Doctor for the Id: "+ doctor.getDoctorId()));
		d.setDoctorName(doctor.getDoctorName());
		d.setDoctorMobile(doctor.getDoctorMobile());
		d.setDoctorEmail(doctor.getDoctorEmail());
		d.setDoctorConsultationTime(doctor.getDoctorConsultationTime());
		d.setDoctorUsername(doctor.getDoctorUsername());
		d.setDoctorPassword(doctor.getDoctorPassword());
		d.setDoctorAddress(doctor.getDoctorAddress());
		d.setTest(doctor.getTest());
		return DocRepo.saveAndFlush(d);
	}

	@Override
	public Doctor deleteDoctor(int doctorId) throws DoctorIdNotFoundException{
		Doctor d =DocRepo.findById(doctorId).orElseThrow(()->new DoctorIdNotFoundException("Invalid Doctor for the Id: "+ doctorId));
		DocRepo.deleteById(doctorId);
		return d;
	}

	@Override
	public Doctor viewDoctor(int doctorId)  throws DoctorIdNotFoundException{
		Doctor d =DocRepo.findById(doctorId).orElseThrow(()->new DoctorIdNotFoundException("Invalid Doctor for the Id: "+ doctorId));
		return d;
	}

	@Override
	public List<Doctor> viewDoctorsList() {
		return DocRepo.findAll();
	}

	@Override
	public List<Appointment> viewAppointments() {
		List<Doctor> listDoc=DocRepo.findAll();
		List<Appointment> list=new ArrayList<Appointment>();
		for(Doctor d:listDoc) {
			for(Appointment a:d.getAppointment()) {
				list.add(a);
			}
		}
		return list;
	}
	@Override
	public Test createTest(int doctorId, Test test) {
		Doctor d=DocRepo.getById(doctorId);
		d.setTest(test);
		return test;
	}

	

}
