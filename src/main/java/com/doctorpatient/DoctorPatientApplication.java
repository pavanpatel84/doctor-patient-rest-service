package com.doctorpatient;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DoctorPatientApplication {

    public static void main(String[] args) {
        try{
            SpringApplication.run(DoctorPatientApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
