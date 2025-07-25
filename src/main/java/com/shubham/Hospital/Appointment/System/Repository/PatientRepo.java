package com.shubham.Hospital.Appointment.System.Repository;

import com.shubham.Hospital.Appointment.System.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
}
