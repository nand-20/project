package com.cg.oeca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oeca.dto.Report;

@Repository
public interface IReportRepository extends JpaRepository<Report, Integer> {

}
