package com.cg.oeca.service;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.oeca.dto.Report;
import com.cg.oeca.dto.Spectacles;
import com.cg.oeca.exceptions.PatientIdFoundNotException;
import com.cg.oeca.exceptions.ReportIdNotFoundException;
@Component//@Component  allows Spring to automatically detect our custom beans
public interface IReportService {
	Report addReport(Report report);
	Report updateReport(Report report) throws ReportIdNotFoundException;
	Report removeReport(int reportId) throws ReportIdNotFoundException;
	Report viewReport(int reportId, int patientId) throws ReportIdNotFoundException,PatientIdFoundNotException;
	List<Report> viewAllReport(LocalDate date);
	List<Spectacles> viewSpetacles();
}
