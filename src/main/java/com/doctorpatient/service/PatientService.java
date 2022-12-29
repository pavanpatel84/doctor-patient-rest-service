package com.doctorpatient.service;

import com.doctorpatient.domain.model.Patient;
import java.util.List;

public interface PatientService {

	Patient savePatient(Patient patient);

	List<Patient> listAllPatients();

	Patient getPatientById(int patientId);

	Patient updatePatientById(int patientId, Patient patient);

	void deletePatientById(int patientId);

	Patient assignDoctorToPatient(int patientId, int doctorId);
}
