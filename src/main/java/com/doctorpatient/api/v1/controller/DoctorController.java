package com.doctorpatient.api.v1.controller;

import com.doctorpatient.api.v1.request.doctor.DoctorRequest;
import com.doctorpatient.api.v1.request.patient.PatientRequest;
import com.doctorpatient.domain.model.Doctor;
import com.doctorpatient.domain.model.Patient;
import com.doctorpatient.dto.DoctorDto;
import com.doctorpatient.exception.EntityException;
import com.doctorpatient.exception.EntityNotFoundException;
import com.doctorpatient.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/v1/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/list")
    public List<DoctorDto> listAllDoctors() {
        List<Doctor> doctors = doctorService.listAllDoctors();
        if (doctors != null && !doctors.isEmpty()) {
            return doctors
                    .stream()
                    .map(doctor -> modelMapper.map(doctor, DoctorDto.class))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();

    }

    @GetMapping("/{id}")
    public DoctorDto getDoctorById(@PathVariable("id") int doctorId) throws EntityNotFoundException {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        if (doctor != null) {
            return modelMapper.map(doctor, DoctorDto.class);
        }
        return null;
    }

    @PostMapping("/add")
    public DoctorDto saveDoctor(@RequestBody @Valid DoctorRequest doctorRequest) throws EntityException {
        Doctor doctor = doctorService.saveDoctor(modelMapper.map(doctorRequest, Doctor.class));
        if (doctor != null) {
            return modelMapper.map(doctor, DoctorDto.class);
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctorNameById(@PathVariable("id") int doctorId, @RequestParam(name = "name", required = true) String doctorName) throws EntityNotFoundException {
        return new ResponseEntity<Doctor>(doctorService.updateDoctorNameById(doctorId, doctorName), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctorById(@PathVariable("id") int doctorId) throws EntityNotFoundException {
        doctorService.deleteDoctorById(doctorId);
        return new ResponseEntity<String>("Doctor deleted successfully.", HttpStatus.OK);
    }

    @PostMapping("/{id}/patient")
    public ResponseEntity<String> addPatientUnderDoctor(@PathVariable("id") int doctorId, @RequestBody @Valid PatientRequest patientRequest) {
        doctorService.addPatientUnderDoctor(doctorId, modelMapper.map(patientRequest, Patient.class));
        return new ResponseEntity<String>("Patient added under doctor successfully.", HttpStatus.OK);
    }

    @PutMapping("/{id}/patient/{pId}")
    public ResponseEntity<String> dischargePatient(@PathVariable("id") int doctorId, @PathVariable("pId") int patientId) {
        doctorService.dischargePatient(doctorId, patientId);
        return new ResponseEntity<String>("Patient discharged successfully.", HttpStatus.OK);
    }
}
