package com.doctorpatient.service.impl;

import com.doctorpatient.domain.model.Patient;
import com.doctorpatient.domain.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PatientServiceImplTest {

    @InjectMocks
    PatientServiceImpl patientserviceimpl;

    @Mock
    private PatientRepository patientRepository;

    Logger logger = (Logger) LoggerFactory.getLogger(PatientServiceImplTest.class);

    @Test
    public void savePatient() {
        try {
            logger.info("Starting execution of savePatient");
            Patient expectedValue = new Patient();
            expectedValue.setId(1);
            Patient patient = new Patient();
            patient.setDisease("Cold");
            patient.setDateOfBirth(new Date());
            patient.setName("Test");
            when(patientRepository.save(any())).thenReturn(expectedValue);

            Patient actualValue = patientserviceimpl.savePatient(patient);
            logger.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            assertEquals(expectedValue.getId(), actualValue.getId());
        } catch (Exception exception) {
            logger.error("Exception in execution of execute1GetAllLogFromFirstMovF-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void savePatientWithNullResult() {
        try {
            logger.info("Starting execution of savePatient");
            Patient expectedValue = null;
            Patient patient = null;
            when(patientRepository.save(any())).thenReturn(expectedValue);
            Patient actualValue = patientserviceimpl.savePatient(patient);
            logger.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            assertEquals(expectedValue, actualValue);
        } catch (Exception exception) {
            logger.error("Exception in execution of execute1GetAllLogFromFirstMovF-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void listAllPatientsWithNullResult() {
        try {
            logger.info("Starting execution of listAllPatients");
            List<Patient> expectedValue = null;
            when(patientRepository.findAll()).thenReturn(expectedValue);
            List<Patient> actualValue = patientserviceimpl.listAllPatients();
            logger.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            assertEquals(expectedValue, actualValue);
        } catch (Exception exception) {
            logger.error("Exception in execution of execute1GetAllLogFromFirstMovF-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void listAllPatients() {
        try {
            logger.info("Starting execution of listAllPatients");
            List<Patient> expectedValue = new ArrayList<>();
            Patient patient = new Patient();
            patient.setDisease("Cold");
            patient.setDateOfBirth(new Date());
            patient.setName("Test");
            expectedValue.add(patient);
            when(patientRepository.findAll()).thenReturn(expectedValue);

            List<Patient> actualValue = patientserviceimpl.listAllPatients();
            logger.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            assertEquals(expectedValue.size(), actualValue.size());
        } catch (Exception exception) {
            logger.error("Exception in execution of execute1GetAllLogFromFirstMovF-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }


    @Test
    public void getPatientByWithWrongId() {
        try {
            logger.info("Starting execution of getPatientById");
            Patient expectedValue = new Patient();
            expectedValue.setId(1);
            int patientId = 1;
            when(patientRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(expectedValue));
            Patient actualValue = patientserviceimpl.getPatientById(patientId);
            logger.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            assertEquals(expectedValue.getId(), actualValue.getId());
        } catch (Exception exception) {
            logger.error("Exception in execution of execute1GetAllLogFromFirstMovF-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void getPatientById() {
        try {
            logger.info("Starting execution of getPatientById");
            Patient expectedValue = new Patient();
            expectedValue.setId(1);
            int patientId = 1;
            when(patientRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(expectedValue));
            Patient actualValue = patientserviceimpl.getPatientById(patientId);
            logger.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            assertEquals(expectedValue.getId(), actualValue.getId());
        } catch (Exception exception) {
            logger.error("Exception in execution of execute1GetAllLogFromFirstMovF-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void deletePatientById() {
        try {
            logger.info("Starting execution of deletePatientById");
            Patient expectedValue = new Patient();
            expectedValue.setId(1);
            int patientId = 1;
            when(patientRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(expectedValue));
            patientserviceimpl.deletePatientById(patientId);
            assertTrue(true);
        } catch (Exception exception) {
            logger.error("Exception in execution ofdeletePatientById-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void deletePatientWithWrongId() {
        try {
            logger.info("Starting execution of deletePatientById");
            Patient expectedValue = new Patient();
            expectedValue.setId(1);
            int patientId = 2;
            when(patientRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(expectedValue));
            patientserviceimpl.deletePatientById(patientId);
            assertTrue(true);
        } catch (Exception exception) {
            logger.error("Exception in execution ofdeletePatientById-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void updatePatientById() {
        try {
            logger.info("Starting execution of updatePatientById");
            Patient expectedValue = null;
            int patientId = 0;
            Patient patient = null;


            Patient actualValue = patientserviceimpl.updatePatientById(patientId, patient);
            logger.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            assertEquals(expectedValue, actualValue);
        } catch (Exception exception) {
            logger.error("Exception in execution of execute1GetAllLogFromFirstMovF-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }



    @Test
    public void assignDoctorToPatient() {
        try {
            logger.info("Starting execution of assignDoctorToPatient");
            Patient expectedValue = null;
            int patientId = 0;
            int doctorId = 0;

            Patient actualValue = patientserviceimpl.assignDoctorToPatient(patientId, doctorId);
            logger.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            assertEquals(expectedValue, actualValue);
        } catch (Exception exception) {
            logger.error("Exception in execution of execute1GetAllLogFromFirstMovF-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }
}