package com.cg.oeca.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oeca.dto.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment,Integer>{
}
