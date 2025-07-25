package com.shubham.Hospital.Appointment.System.Repository;

import com.shubham.Hospital.Appointment.System.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
}
