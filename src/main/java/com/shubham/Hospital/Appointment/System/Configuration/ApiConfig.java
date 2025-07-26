package com.shubham.Hospital.Appointment.System.Configuration;

import com.shubham.Hospital.Appointment.System.Dto.PatientDto;
import com.shubham.Hospital.Appointment.System.Entity.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.config.Configuration.AccessLevel;
@Configuration
public class ApiConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }
}
