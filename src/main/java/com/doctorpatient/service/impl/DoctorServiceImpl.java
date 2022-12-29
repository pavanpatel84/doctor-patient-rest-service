package com.doctorpatient.service.impl;

import com.doctorpatient.domain.model.Doctor;
import com.doctorpatient.domain.model.Patient;
import com.doctorpatient.domain.repository.DoctorRepository;
import com.doctorpatient.domain.repository.PatientRepository;
import com.doctorpatient.exception.DoctorNotDeletedException;
import com.doctorpatient.exception.ResourceNotFoundException;
import com.doctorpatient.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    Logger logger = (Logger) LoggerFactory.getLogger(DoctorServiceImpl.class);

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        logger.info("Saving doctor record!!!");
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> listAllDoctors() {
        logger.info("Retrieving list of doctor records!!!");
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(int doctorId) {
        logger.info("Retrieving doctor record with Doctor Id : {}", doctorId);
        return doctorRepository.findById(doctorId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Doctor", "Id", doctorId));
    }


    @Override
    public Doctor updateDoctorNameById(int doctorId, String doctorName) {
        logger.info("Updating doctor name to '{}' for record with Doctor Id : {}", doctorName, doctorId);
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Id", doctorId));

        doctor.setName(doctorName);
        doctorRepository.save(doctor);
        return doctor;
    }

    @Override
    public void deleteDoctorById(int doctorId) {
        logger.info("Deleting doctor record with Doctor Id : {}", doctorId);

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Id", doctorId));

        if (doctor.getPatients().size() > 0) {
            logger.error("Error deleting doctor record with Doctor Id : {}", doctorId);
            throw new DoctorNotDeletedException(doctorId);
        } else {
            logger.info("Doctor record with Doctor Id : {} is deleted successfully", doctorId);
            doctorRepository.deleteById(doctorId);
        }
    }

    @Override
    public void addPatientUnderDoctor(int doctorId, Patient patient) {
        logger.info("Adding new patient under doctor with Doctor Id : {}", doctorId);
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Id", doctorId));
        doctor.addPatient(patient);
        doctorRepository.save(doctor);
        patientRepository.save(patient);
    }

    @Override
    public void dischargePatient(int doctorId, int patientId) {
        logger.info("Discharging patient with Patient Id : {} from doctor with Doctor Id : {}", patientId, doctorId);
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Id", doctorId));
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", patientId));
        doctor.removePatient(patient);
        doctorRepository.save(doctor);
        patientRepository.save(patient);
    }
}
