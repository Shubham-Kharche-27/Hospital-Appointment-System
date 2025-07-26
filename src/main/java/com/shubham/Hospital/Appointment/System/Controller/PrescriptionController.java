package com.shubham.Hospital.Appointment.System.Controller;

import com.shubham.Hospital.Appointment.System.Dto.PrescriptionDto;
import com.shubham.Hospital.Appointment.System.Service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/get")
    public ResponseEntity<Page<PrescriptionDto>> getAllPrescriptionData(
            @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "3")int pageSize,
            @RequestParam(defaultValue = "prescriptionId")String sortBy
    ){
        return new ResponseEntity<>(prescriptionService.getAllPrescriptionData(pageNum-1,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping("/get/byId/{prescriptionId}")
    public ResponseEntity<PrescriptionDto> getPrescriptionById(@PathVariable Long prescriptionId){
        return new ResponseEntity<>(prescriptionService.getPrescriptionDataById(prescriptionId),HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createPrescription(@RequestBody PrescriptionDto prescriptionDto){
        return new ResponseEntity<>(prescriptionService.createPrescription(prescriptionDto),HttpStatus.CREATED);
    }

    @PutMapping("/put/{prescriptionId}")
    public ResponseEntity<String> updatePrescription(@PathVariable Long prescriptionId,@RequestBody PrescriptionDto prescriptionDto){
        return new ResponseEntity<>(prescriptionService.updatePrescriptionData(prescriptionId,prescriptionDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{prescriptionId}")
    public ResponseEntity<String> deletePrescription(@PathVariable Long prescriptionId){
        return new ResponseEntity<>(prescriptionService.deletePrescriptionData(prescriptionId),HttpStatus.NO_CONTENT);
    }
}
