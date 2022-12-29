package com.doctorpatient.service;

import com.doctorpatient.domain.model.Doctor;
import com.doctorpatient.domain.model.Patient;

import java.util.List;

public interface DoctorService {

    Doctor saveDoctor(Doctor doctor);

    List<Doctor> listAllDoctors();

    Doctor getDoctorById(int doctorId);

    Doctor updateDoctorNameById(int doctorId, String doctorName);

    void deleteDoctorById(int doctorId);

    void addPatientUnderDoctor(int doctorId, Patient patient);

    void dischargePatient(int doctorId, int patientId);
}
