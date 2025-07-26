package com.shubham.Hospital.Appointment.System.Controller;

import com.shubham.Hospital.Appointment.System.Dto.PatientDto;
import com.shubham.Hospital.Appointment.System.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/get")
    public ResponseEntity<Page<PatientDto>> getAllPatient(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "patientId") String sortBy
    ) {
        return new ResponseEntity<>(patientService.getAllPatientData(pageNum - 1, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping("/get/byId/{patientId}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long patientId) {
        return new ResponseEntity<>(patientService.getPatientDataById(patientId), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createPatient(@RequestBody PatientDto patientDto) {
        return new ResponseEntity<>(patientService.createPatientData(patientDto), HttpStatus.CREATED);
    }

    @PutMapping("/put/{patientId}")
    public ResponseEntity<String> updatePatient(@PathVariable Long patientId, @RequestBody PatientDto patientDto) {
        return new ResponseEntity<>(patientService.updatePatientData(patientId, patientDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientId) {
        return new ResponseEntity<>(patientService.deletePatientData(patientId), HttpStatus.NO_CONTENT);
    }
}
