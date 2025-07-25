package com.shubham.Hospital.Appointment.System.Dto;

import com.shubham.Hospital.Appointment.System.Entity.Appointment;

import java.time.LocalDateTime;

public class PrescriptionDto {
    private Long prescriptionId;
    private Long appointmentId;
    private String medication;
    private String diagnosis;
    private String advice;
    private LocalDateTime prescriptionCreatedAt;

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public LocalDateTime getPrescriptionCreatedAt() {
        return prescriptionCreatedAt;
    }

    public void setPrescriptionCreatedAt(LocalDateTime prescriptionCreatedAt) {
        this.prescriptionCreatedAt = prescriptionCreatedAt;
    }
}
