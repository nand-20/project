package com.cg.oeca.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oeca.dto.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer>{
}