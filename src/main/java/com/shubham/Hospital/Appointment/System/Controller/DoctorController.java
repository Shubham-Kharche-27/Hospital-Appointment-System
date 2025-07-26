package com.shubham.Hospital.Appointment.System.Controller;

import com.shubham.Hospital.Appointment.System.Dto.DoctorDto;
import com.shubham.Hospital.Appointment.System.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/get")
    public ResponseEntity<Page<DoctorDto>> getAllDoctor(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "doctorId") String sortBy
    ) {
        return new ResponseEntity<>(doctorService.getAllDoctorData(pageNum - 1, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping("/get/byId/{doctorId}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long doctorId) {
        return new ResponseEntity<>(doctorService.getDoctorDataById(doctorId), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createDoctor(@RequestBody DoctorDto doctorDto) {
        return new ResponseEntity<>(doctorService.createDoctorData(doctorDto), HttpStatus.CREATED);
    }

    @PutMapping("/put/{doctorId}")
    public ResponseEntity<String> updateDoctor(@PathVariable Long doctorId, @RequestBody DoctorDto doctorDto) {
        return new ResponseEntity<>(doctorService.updateDoctorData(doctorId, doctorDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{doctorId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long doctorId) {
        return new ResponseEntity<>(doctorService.deleteDoctorData(doctorId), HttpStatus.NO_CONTENT);
    }
}
