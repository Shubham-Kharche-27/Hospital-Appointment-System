package com.shubham.Hospital.Appointment.System.Controller;

import com.shubham.Hospital.Appointment.System.Dto.AppointmentDto;
import com.shubham.Hospital.Appointment.System.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/get")
    public ResponseEntity<Page<AppointmentDto>> getAllAppointment(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "appointmentId") String sortBy
    ) {
        return new ResponseEntity<>(appointmentService.getAllAppointmentData(pageNum - 1, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping("/get/byId/{appointmentId}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long appointmentId){
        return new ResponseEntity<>(appointmentService.getAppointmentDataById(appointmentId),HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createAppointment(@RequestBody AppointmentDto appointmentDto){
        return new ResponseEntity<>(appointmentService.createAppointmentData(appointmentDto),HttpStatus.CREATED);
    }

    @PutMapping("/put/{appointmentId}")
    public ResponseEntity<String> updateAppointment(@PathVariable Long appointmentId,@RequestBody AppointmentDto appointmentDto){
        return new ResponseEntity<>(appointmentService.updateAppointmentData(appointmentId,appointmentDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{appointmentId}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long appointmentId){
        return new ResponseEntity<>(appointmentService.deleteAppointment(appointmentId),HttpStatus.NO_CONTENT);
    }
}
