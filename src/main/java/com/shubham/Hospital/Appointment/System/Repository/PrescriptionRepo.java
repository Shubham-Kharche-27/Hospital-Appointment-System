package com.shubham.Hospital.Appointment.System.Repository;

import com.shubham.Hospital.Appointment.System.Entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepo extends JpaRepository<Prescription, Long> {
}
