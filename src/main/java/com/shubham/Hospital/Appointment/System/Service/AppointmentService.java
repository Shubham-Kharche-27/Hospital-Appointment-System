package com.shubham.Hospital.Appointment.System.Service;

import com.shubham.Hospital.Appointment.System.Dto.AppointmentDto;
import com.shubham.Hospital.Appointment.System.Entity.Appointment;
import com.shubham.Hospital.Appointment.System.Entity.Doctor;
import com.shubham.Hospital.Appointment.System.Entity.Patient;
import com.shubham.Hospital.Appointment.System.Exception.AppointmentNotFoundException;
import com.shubham.Hospital.Appointment.System.Exception.DoctorNotFoundException;
import com.shubham.Hospital.Appointment.System.Exception.PatientNotFoundException;
import com.shubham.Hospital.Appointment.System.Repository.AppointmentRepo;
import com.shubham.Hospital.Appointment.System.Repository.DoctorRepo;
import com.shubham.Hospital.Appointment.System.Repository.PatientRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Page<AppointmentDto> getAllAppointmentData(int pageNum, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        Page<Appointment> appointmentPage = appointmentRepo.findAll(pageable);
        Page<AppointmentDto> appointmentDtos = appointmentPage.map(Appointment -> modelMapper.map(Appointment, AppointmentDto.class));
        return appointmentDtos;
    }

    public AppointmentDto getAppointmentDataById(Long appointmentId) {
        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment does not exist!"));
        return modelMapper.map(appointment, AppointmentDto.class);
    }

    public String createAppointmentData(AppointmentDto appointmentDto) {
        if (appointmentDto == null) {
            throw new AppointmentNotFoundException("Appointment data is empty!");
        }
        Appointment appointment = modelMapper.map(appointmentDto, Appointment.class);
        Patient patient = patientRepo.findById(appointmentDto.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException("Patient does not exist!"));
        Doctor doctor = doctorRepo.findById(appointmentDto.getDoctorId())
                .orElseThrow(() -> new DoctorNotFoundException("Doctor does not exist!"));
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointmentRepo.save(appointment);
        return "Appointment created successfully!";
    }

    public String updateAppointmentData(Long appointmentId, AppointmentDto appointmentDto) {
        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment does not exist!"));
        if (appointmentDto.getAppointmentDate() != null) {
            appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        }
        if (appointmentDto.getAppointmentTime() != null) {
            appointment.setAppointmentTime(appointmentDto.getAppointmentTime());
        }
        if (appointmentDto.getAppointmentStatus() != null) {
            appointment.setAppointmentStatus(appointmentDto.getAppointmentStatus());
        }
        if (appointmentDto.getAppointmentNotes() != null) {
            appointment.setAppointmentNotes(appointmentDto.getAppointmentNotes());
        }
        appointmentRepo.save(appointment);
        return "Appointment updated successfully!";
    }

    public String deleteAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment does not exist!"));
        appointmentRepo.deleteById(appointmentId);
        return "Appointment deleted successfully!";
    }
}
