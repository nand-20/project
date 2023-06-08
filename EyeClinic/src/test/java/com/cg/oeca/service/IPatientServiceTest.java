package com.cg.oeca.service;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oeca.dto.Appointment;
import com.cg.oeca.dto.Patient;
import com.cg.oeca.repository.IPatientRepository;

@SpringBootTest
class IPatientServiceTest {

	@Autowired
	IPatientRepository pRepo;

	@Test
	public void addPatientTest() {
		Patient p = new Patient();
		p.setPatientName("Bhavana");
		p.setPatientAge(21);
		p.setPatientMobile(9100532241L);
		p.setPatientEmail("bhavana@gmail.com");
		pRepo.saveAndFlush(p);
		assertFalse(pRepo.findAll().size() == 0);
	}

	@Test
	public void viewPatientListTest() {
		assertFalse(pRepo.findAll().size() == 0);
	}

	@Test
	public void viewPatientTest() {
		Patient p = pRepo.getById(1);
		assertFalse(1 != p.getPatientId());
	}

	@Test
	public void updatePatientTest() {
		Patient p = pRepo.getById(1);
		p.setPatientName("Manaswini");
		p.setPatientAge(20);
		p.setPatientMobile(9100532241L);
		p.setPatientEmail("manas@gmail.com");
		pRepo.saveAndFlush(p);
		assertFalse("Manaswini" != pRepo.getById(1).getPatientName());
	}

	@Test
	public void bookAppointmentTest() {
		Patient p = pRepo.getById(1);
		Appointment a = new Appointment();
		a.setDateOfAppointment(LocalDate.parse("2022-04-15", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		a.setConsultationFee(500);
		a.setTimeOfAppointment(LocalTime.parse("10:30", DateTimeFormatter.ofPattern("HH:mm")));
		p.setAppointment(a);
		pRepo.saveAndFlush(p);
		assertFalse(500 != p.getAppointment().getConsultationFee());
	}

	@Test
	public void viewAppointmentTest() {
		Patient p = pRepo.findById(1).get();
		assertFalse(500 != p.getAppointment().getConsultationFee());
	}

	@Test
	public void viewReportTest() {
		Patient p = pRepo.getById(1);
		assertFalse(p.getReport() == null);
	}

	@Test
	public void deletePatientTest() {
		pRepo.deleteById(1);
		assertFalse(pRepo.getById(1) != null);

	}
}
