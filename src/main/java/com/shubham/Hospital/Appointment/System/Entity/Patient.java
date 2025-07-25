package com.shubham.Hospital.Appointment.System.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String patientName;
    @Enumerated(EnumType.STRING)
    private Gender patientGender;
    private LocalDate patientDob;
    private String patientEmail;
    private Long patientMobNum;
    private String patientAddress;
    @Enumerated(EnumType.STRING)
    private BloodGroup patientBloodGroup;
    private LocalDateTime patientCreatedAt;

    @OneToMany(mappedBy = "patient", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Appointment> appointments = new HashSet<>();

    @PrePersist
    protected void onCreate() {
        patientCreatedAt = LocalDateTime.now();
    }

    public Patient(Long patientId, String patientName, Gender patientGender, LocalDate patientDob, String patientEmail, Long patientMobNum, String patientAddress, BloodGroup patientBloodGroup, LocalDateTime patientCreatedAt, Set<Appointment> appointments) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientGender = patientGender;
        this.patientDob = patientDob;
        this.patientEmail = patientEmail;
        this.patientMobNum = patientMobNum;
        this.patientAddress = patientAddress;
        this.patientBloodGroup = patientBloodGroup;
        this.patientCreatedAt = patientCreatedAt;
        this.appointments = appointments;
    }

    public Patient() {
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Gender getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(Gender patientGender) {
        this.patientGender = patientGender;
    }

    public LocalDate getPatientDob() {
        return patientDob;
    }

    public void setPatientDob(LocalDate patientDob) {
        this.patientDob = patientDob;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public Long getPatientMobNum() {
        return patientMobNum;
    }

    public void setPatientMobNum(Long patientMobNum) {
        this.patientMobNum = patientMobNum;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public BloodGroup getPatientBloodGroup() {
        return patientBloodGroup;
    }

    public void setPatientBloodGroup(BloodGroup patientBloodGroup) {
        this.patientBloodGroup = patientBloodGroup;
    }

    public LocalDateTime getPatientCreatedAt() {
        return patientCreatedAt;
    }

    public void setPatientCreatedAt(LocalDateTime patientCreatedAt) {
        this.patientCreatedAt = patientCreatedAt;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}
