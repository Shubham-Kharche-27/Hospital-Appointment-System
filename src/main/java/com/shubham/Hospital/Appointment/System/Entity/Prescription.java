package com.shubham.Hospital.Appointment.System.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointmentId")
    @JsonBackReference
    private Appointment appointment;

    private String medication;
    private String diagnosis;
    private String advice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime prescriptionCreatedAt;

    @PrePersist
    protected void createdAt() {
        prescriptionCreatedAt = LocalDateTime.now();
    }

    public Prescription(Long prescriptionId, Appointment appointment, String medication, String diagnosis, String advice, LocalDateTime prescriptionCreatedAt) {
        this.prescriptionId = prescriptionId;
        this.appointment = appointment;
        this.medication = medication;
        this.diagnosis = diagnosis;
        this.advice = advice;
        this.prescriptionCreatedAt = prescriptionCreatedAt;
    }

    public Prescription() {
    }

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
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
