package com.cg.oeca.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oeca.dto.Report;
import com.cg.oeca.dto.Spectacles;
import com.cg.oeca.exceptions.PatientIdFoundNotException;
import com.cg.oeca.exceptions.ReportIdNotFoundException;
import com.cg.oeca.repository.IReportRepository;
@Service//@Service annotates classes that perform service tasks
public class ReportServiceImpl implements IReportService{
	@Autowired//@Autowired automatically injects the dependent beans into the associated references of a POJO class
	private IReportRepository RepRepo;	
	//Constructor
	public ReportServiceImpl() {
		super();	}
	//Parameterized constructor
	public ReportServiceImpl(IReportRepository repRepo) {
		super();
		RepRepo = repRepo;
	}
	//implementing unimplemented methods
	@Override
	public Report addReport(Report report) {
		return RepRepo.saveAndFlush(report);
	}

	@Override
	public Report updateReport(Report report) throws ReportIdNotFoundException  {
		Report r=RepRepo.findById(report.getReportId()).orElseThrow(()->new ReportIdNotFoundException("Invalid Report for this Id: "+report.getReportId()));
		r.setDateOfReport(report.getDateOfReport());
		r.setDescriptionOfReport(report.getDescriptionOfReport());
		r.setVisualAcuity(report.getVisualAcuity());
		r.setVisualAcuityForNear(report.getVisualAcuityForNear());
		r.setVisualAcuityForDistance(report.getVisualAcuityForDistance());
		return RepRepo.saveAndFlush(r);
	}

	@Override
	public Report removeReport(int reportId) throws ReportIdNotFoundException {
		Report r=RepRepo.findById(reportId).orElseThrow(()->new ReportIdNotFoundException("Invalid Report for this Id: "+reportId));
		RepRepo.deleteById(reportId);
		return r;
	}

	@Override
	public Report viewReport(int reportId, int patientId) throws ReportIdNotFoundException, PatientIdFoundNotException {
		Report r=RepRepo.findById(reportId).orElseThrow(()->new ReportIdNotFoundException("Invalid Report for this Id: "+reportId));
		if(r.getPatient().getPatientId()==patientId) {
			return r;
		}
		throw new PatientIdFoundNotException("No Patient Found with id: "+patientId);
	}

	@Override
	public List<Report> viewAllReport(LocalDate date) {
		List<Report> listRep=RepRepo.findAll();
		List<Report> list=new ArrayList<Report>();
		for(Report r:listRep) {
			if(r.getDateOfReport().isEqual(date)) {
				list.add(r);
			}
		}
		return list;
	}

	@Override
	public List<Spectacles> viewSpetacles() {
		List<Report> listRep=RepRepo.findAll();
		List<Spectacles> list=new ArrayList<Spectacles>();
		for(Report r:listRep) {
			if(r.getSpectacles()!=null) {
				list.add(r.getSpectacles());
			}
		}
		return list;
	}

}
