package com.shubham.Hospital.Appointment.System.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String doctorName;
    @Enumerated(EnumType.STRING)
    private Gender doctorGender;
    private LocalDate doctorDob;
    private String doctorSpecialization;
    private String doctorEmail;
    private Long doctorPhoneNum;
    private String doctorExperience;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime doctorCreatedAt;

    @OneToMany(mappedBy = "doctor", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JsonManagedReference(value = "doctorReference")
    private Set<Appointment> appointments = new HashSet<>();

    @PrePersist
    protected void createdAt() {
        doctorCreatedAt = LocalDateTime.now();
    }

    public Doctor(Long doctorId, String doctorName, Gender doctorGender, LocalDate doctorDob, String doctorSpecialization, String doctorEmail, Long doctorPhoneNum, String doctorExperience, LocalDateTime doctorCreatedAt, Set<Appointment> appointments) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorGender = doctorGender;
        this.doctorDob = doctorDob;
        this.doctorSpecialization = doctorSpecialization;
        this.doctorEmail = doctorEmail;
        this.doctorPhoneNum = doctorPhoneNum;
        this.doctorExperience = doctorExperience;
        this.doctorCreatedAt = doctorCreatedAt;
        this.appointments = appointments;
    }

    public Doctor() {
    }

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
