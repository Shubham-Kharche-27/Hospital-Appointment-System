package com.shubham.Hospital.Appointment.System.Service;

import com.shubham.Hospital.Appointment.System.Dto.PrescriptionDto;
import com.shubham.Hospital.Appointment.System.Entity.Appointment;
import com.shubham.Hospital.Appointment.System.Entity.Prescription;
import com.shubham.Hospital.Appointment.System.Exception.AppointmentNotFoundException;
import com.shubham.Hospital.Appointment.System.Exception.PrescriptionNotFoundException;
import com.shubham.Hospital.Appointment.System.Repository.AppointmentRepo;
import com.shubham.Hospital.Appointment.System.Repository.PrescriptionRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepo prescriptionRepo;

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PrescriptionDto> getAllPrescriptionData(int pageNum, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        Page<Prescription> prescriptionPage = prescriptionRepo.findAll(pageable);
        return prescriptionPage.map(Prescription -> modelMapper.map(Prescription, PrescriptionDto.class));
    }

    public PrescriptionDto getPrescriptionDataById(Long prescriptionId) {
        Prescription prescription = prescriptionRepo.findById(prescriptionId)
                .orElseThrow(() -> new PrescriptionNotFoundException("Prescription does not exist!"));
        return modelMapper.map(prescription, PrescriptionDto.class);
    }

    public String createPrescription(PrescriptionDto prescriptionDto) {
        if (prescriptionDto == null) {
            throw new PrescriptionNotFoundException("Prescription data is empty!");
        }
        Prescription prescription = modelMapper.map(prescriptionDto, Prescription.class);
        Appointment appointment = appointmentRepo.findById(prescriptionDto.getAppointmentId())
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment does not exist!"));
        prescription.setAppointment(appointment);
        prescriptionRepo.save(prescription);
        return "Prescription created successfully!";
    }

    public String updatePrescriptionData(Long prescriptionId, PrescriptionDto prescriptionDto) {
        Prescription prescription = prescriptionRepo.findById(prescriptionId)
                .orElseThrow(() -> new PrescriptionNotFoundException("Prescription does mot exist!"));
        if(prescriptionDto.getMedication()!=null){
            prescription.setMedication(prescriptionDto.getMedication());
        }
        if(prescriptionDto.getDiagnosis()!=null){
            prescription.setDiagnosis(prescriptionDto.getDiagnosis());
        }
        if(prescriptionDto.getAdvice()!=null){
            prescription.setAdvice(prescriptionDto.getAdvice());
        }
        prescriptionRepo.save(prescription);
        return "Prescription data updated successfully!";
    }

    public String deletePrescriptionData(Long prescriptionId){
        Prescription prescription = prescriptionRepo.findById(prescriptionId)
                .orElseThrow(()->new PrescriptionNotFoundException("Prescription does not exist!"));
        prescriptionRepo.deleteById(prescriptionId);
        return "Prescription deleted successfully!";
    }
}
