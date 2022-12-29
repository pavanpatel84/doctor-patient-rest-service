package com.doctorpatient.service.impl;

import com.doctorpatient.domain.model.Doctor;
import com.doctorpatient.domain.model.Patient;
import com.doctorpatient.domain.repository.DoctorRepository;
import com.doctorpatient.domain.repository.PatientRepository;
import com.doctorpatient.exception.ResourceNotFoundException;
import com.doctorpatient.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    Logger logger = (Logger) LoggerFactory.getLogger(PatientServiceImpl.class);

    @Override
    public Patient savePatient(Patient patient) {
        logger.info("Saving patient record!!!");
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> listAllPatients() {
        logger.info("Retrieving list of patient records!!!");
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(int patientId) {
        logger.info("Retrieving patient record with Patient Id : {}", patientId);
        return patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", patientId));
    }

    @Override
    public Patient updatePatientById(int patientId, Patient patient) {
        logger.info("Updating patient record with Patient Id : {}", patientId);
        Patient existingPatient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", patientId));

        existingPatient.setName(patient.getName());
        existingPatient.setDisease(patient.getDisease());
        existingPatient.setDateOfBirth(patient.getDateOfBirth());

        patientRepository.save(existingPatient);
        return existingPatient;
    }

    @Override
    public void deletePatientById(int patientId) {
        logger.info("Deleting patient record with Patient Id : {}", patientId);
        Patient p = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", patientId));
        patientRepository.deleteById(patientId);
    }

    @Override
    public Patient assignDoctorToPatient(int patientId, int doctorId) {
        logger.info("Assigning doctor with Doctor Id : {} to patient with Patient Id : {}", doctorId, patientId);

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", patientId));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Id", doctorId));
        patient.setDoctor(doctor);
        patientRepository.save(patient);
        return patient;
    }

}
