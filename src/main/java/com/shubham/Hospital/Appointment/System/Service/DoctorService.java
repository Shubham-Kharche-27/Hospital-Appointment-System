package com.shubham.Hospital.Appointment.System.Service;

import com.shubham.Hospital.Appointment.System.Dto.DoctorDto;
import com.shubham.Hospital.Appointment.System.Entity.Doctor;
import com.shubham.Hospital.Appointment.System.Exception.DoctorNotFoundException;
import com.shubham.Hospital.Appointment.System.Repository.DoctorRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Page<DoctorDto> getAllDoctorData(int pageNum, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        Page<Doctor> doctorPage = doctorRepo.findAll(pageable);
        Page<DoctorDto> doctorDtos = doctorPage.map(Doctor -> modelMapper.map(Doctor, DoctorDto.class));
        return doctorDtos;
    }

    public DoctorDto getDoctorDataById(Long doctorId) {
        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor does not exist!"));
        return modelMapper.map(doctor, DoctorDto.class);
    }

    public String createDoctorData(DoctorDto doctorDto) {
        if (doctorDto == null) {
            throw new DoctorNotFoundException("Doctor data is empty!");
        }
        Doctor doctor = modelMapper.map(doctorDto, Doctor.class);
        doctorRepo.save(doctor);
        return "Doctor data created successfully!";
    }

    public String updateDoctorData(Long doctorId, DoctorDto doctorDto) {
        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor does not exist!"));
        if (doctorDto.getDoctorName() != null) {
            doctor.setDoctorName(doctorDto.getDoctorName());
        }
        if (doctorDto.getDoctorGender() != null) {
            doctor.setDoctorGender(doctorDto.getDoctorGender());
        }
        if (doctorDto.getDoctorSpecialization() != null) {
            doctor.setDoctorSpecialization(doctorDto.getDoctorSpecialization());
        }
        if (doctorDto.getDoctorEmail() != null) {
            doctor.setDoctorEmail(doctorDto.getDoctorEmail());
        }
        if (doctorDto.getDoctorPhoneNum() != null) {
            doctor.setDoctorPhoneNum(doctorDto.getDoctorPhoneNum());
        }
        if (doctorDto.getDoctorExperience() != null) {
            doctor.setDoctorExperience(doctorDto.getDoctorExperience());
        }
        if (doctorDto.getDoctorDob() != null) {
            doctor.setDoctorDob(doctorDto.getDoctorDob());
        }
        doctorRepo.save(doctor);
        return "Doctor data updated successfully!";
    }

    public String deleteDoctorData(Long doctorId) {
        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor does not exist!"));
        doctorRepo.deleteById(doctorId);
        return "Doctor data deleted successfully!";
    }
}
