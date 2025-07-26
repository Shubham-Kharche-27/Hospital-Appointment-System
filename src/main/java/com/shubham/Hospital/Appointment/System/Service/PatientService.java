package com.shubham.Hospital.Appointment.System.Service;

import com.shubham.Hospital.Appointment.System.Dto.PatientDto;
import com.shubham.Hospital.Appointment.System.Entity.Patient;
import com.shubham.Hospital.Appointment.System.Exception.PatientNotFoundException;
import com.shubham.Hospital.Appointment.System.Repository.PatientRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PatientDto> getAllPatientData(int pageNum, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        Page<Patient> patientPage = patientRepo.findAll(pageable);
        Page<PatientDto> patientDtos = patientPage.map(Patient -> modelMapper.map(Patient, PatientDto.class));
        return patientDtos;
    }

    public PatientDto getPatientDataById(Long patientId) {
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient does not exist!"));
        PatientDto patientDto = modelMapper.map(patient, PatientDto.class);
        return patientDto;
    }

    @Transactional
    public String createPatientData(PatientDto patientDto) {
        if (patientDto == null) {
            throw new RuntimeException("Patient data is empty");
        }
        Patient patient = modelMapper.map(patientDto, Patient.class);
        patientRepo.save(patient);
        return "Patient created successfully!";
    }

    public String updatePatientData(Long patientId, PatientDto patientDto) {
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient does not exist!"));
        if (patientDto.getPatientName() != null) {
            patient.setPatientName(patientDto.getPatientName());
        }
        if (patientDto.getPatientGender() != null) {
            patient.setPatientGender(patientDto.getPatientGender());
        }
        if (patientDto.getPatientDob() != null) {
            patient.setPatientDob(patientDto.getPatientDob());
        }
        if (patientDto.getPatientEmail() != null) {
            patient.setPatientEmail(patientDto.getPatientEmail());
        }
        if (patientDto.getPatientMobNum() != null) {
            patient.setPatientMobNum(patientDto.getPatientMobNum());
        }
        if (patientDto.getPatientAddress() != null) {
            patient.setPatientAddress(patientDto.getPatientAddress());
        }
        if (patientDto.getPatientBloodGroup() != null) {
            patient.setPatientBloodGroup(patientDto.getPatientBloodGroup());
        }
        patientRepo.save(patient);
        return "Patient data updated successfully!";
    }

    public String deletePatientData(Long patientId) {
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient does not exist!"));
        patientRepo.deleteById(patientId);
        return "Patient data deleted successfully!";
    }
}
