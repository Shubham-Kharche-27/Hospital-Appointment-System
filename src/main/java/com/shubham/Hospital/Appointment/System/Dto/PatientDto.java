package com.shubham.Hospital.Appointment.System.Dto;

import com.shubham.Hospital.Appointment.System.Entity.Appointment;
import com.shubham.Hospital.Appointment.System.Entity.BloodGroup;
import com.shubham.Hospital.Appointment.System.Entity.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class PatientDto {
    private Long patientId;
    private String patientName;
    private Gender patientGender;
    private LocalDate patientDob;
    private String patientEmail;
    private Long patientMobNum;
    private String patientAddress;
    private BloodGroup patientBloodGroup;
    private LocalDateTime patientCreatedAt;
    private Set<Appointment> appointments = new HashSet<>();

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
