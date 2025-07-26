package com.shubham.Hospital.Appointment.System.Dto;

import com.shubham.Hospital.Appointment.System.Entity.AppointmentStatus;
import com.shubham.Hospital.Appointment.System.Entity.Doctor;
import com.shubham.Hospital.Appointment.System.Entity.Patient;
import com.shubham.Hospital.Appointment.System.Entity.Prescription;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AppointmentDto {
    private Long appointmentId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private AppointmentStatus appointmentStatus = AppointmentStatus.PENDING;
    private String appointmentNotes;
    private Long patientId;
    private Long doctorId;
    private LocalDateTime appointmentCreatedAt;
    private Prescription prescription;

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentNotes() {
        return appointmentNotes;
    }

    public void setAppointmentNotes(String appointmentNotes) {
        this.appointmentNotes = appointmentNotes;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getAppointmentCreatedAt() {
        return appointmentCreatedAt;
    }

    public void setAppointmentCreatedAt(LocalDateTime appointmentCreatedAt) {
        this.appointmentCreatedAt = appointmentCreatedAt;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
