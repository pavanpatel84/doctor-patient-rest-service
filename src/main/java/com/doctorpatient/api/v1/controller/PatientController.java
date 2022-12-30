package com.doctorpatient.api.v1.controller;

import com.doctorpatient.api.v1.request.patient.PatientRequest;
import com.doctorpatient.domain.model.Patient;
import com.doctorpatient.dto.PatientDto;
import com.doctorpatient.exception.EntityException;
import com.doctorpatient.exception.EntityNotFoundException;
import com.doctorpatient.service.PatientService;
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
@RequestMapping("/v1/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/list")
    public List<PatientDto> listAllPatients() {
        List<Patient> patients = patientService.listAllPatients();
        if (patients != null && !patients.isEmpty()) {
            return patients
                    .stream()
                    .map(doctor -> mapper.map(doctor, PatientDto.class))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @GetMapping("/{id}")
    public PatientDto getPatientById(@PathVariable("id") int patientId) throws EntityNotFoundException {
        Patient patient = patientService.getPatientById(patientId);
        if (patient != null) {
            return mapper.map(patient, PatientDto.class);
        }
        return null;
    }

    @PostMapping("/add")
    public PatientDto savePatient(@RequestBody @Valid PatientRequest patientRequest) throws EntityException {
        Patient patient = patientService.savePatient(mapper.map(patientRequest, Patient.class));
        if (patient != null) {
            return mapper.map(patient, PatientDto.class);
        }
        return null;

    }

    @PutMapping("/{id}")
    public PatientDto updatePatientById(@PathVariable("id") int patientId, @RequestBody Patient patient) throws EntityNotFoundException {

        Patient updatedPatient = patientService.updatePatientById(patientId, patient);
        if (updatedPatient != null) {
            return mapper.map(updatedPatient, PatientDto.class);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable(name = "id", required = true) int patientId) throws EntityNotFoundException {
        patientService.deletePatientById(patientId);
        return new ResponseEntity<String>("Patient deleted successfully.", HttpStatus.OK);
    }

    // assign doctor to Patient
    @PutMapping("/{pId}/doctor/{dId}")
    public PatientDto assignDoctorToPatient(@PathVariable(name = "pId", required = true) int patientId,
                                                         @PathVariable(name = "dId", required = true) int doctorId) {
        Patient updatedPatient = patientService.assignDoctorToPatient(patientId, doctorId);
        if (updatedPatient != null) {
            return mapper.map(updatedPatient, PatientDto.class);
        }
        return null;
    }
}
