package com.shubham.Hospital.Appointment.System.Dto;

import com.shubham.Hospital.Appointment.System.Entity.Appointment;
import com.shubham.Hospital.Appointment.System.Entity.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class DoctorDto {
    private Long doctorId;
    private String doctorName;
    private Gender doctorGender;
    private LocalDate doctorDob;
    private String doctorSpecialization;
    private String doctorEmail;
    private Long doctorPhoneNum;
    private String doctorExperience;
    private LocalDateTime doctorCreatedAt;
    private Set<Appointment> appointments = new HashSet<>();
    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Gender getDoctorGender() {
        return doctorGender;
    }

    public void setDoctorGender(Gender doctorGender) {
        this.doctorGender = doctorGender;
    }

    public LocalDate getDoctorDob() {
        return doctorDob;
    }

    public void setDoctorDob(LocalDate doctorDob) {
        this.doctorDob = doctorDob;
    }

    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public Long getDoctorPhoneNum() {
        return doctorPhoneNum;
    }

    public void setDoctorPhoneNum(Long doctorPhoneNum) {
        this.doctorPhoneNum = doctorPhoneNum;
    }

    public String getDoctorExperience() {
        return doctorExperience;
    }

    public void setDoctorExperience(String doctorExperience) {
        this.doctorExperience = doctorExperience;
    }

    public LocalDateTime getDoctorCreatedAt() {
        return doctorCreatedAt;
    }

    public void setDoctorCreatedAt(LocalDateTime doctorCreatedAt) {
        this.doctorCreatedAt = doctorCreatedAt;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}
