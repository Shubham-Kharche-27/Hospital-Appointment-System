package com.shubham.Hospital.Appointment.System.Repository;

import com.shubham.Hospital.Appointment.System.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
}
