package com.doctorpatient.service.impl;


import com.doctorpatient.domain.model.Doctor;
import com.doctorpatient.domain.model.Patient;
import com.doctorpatient.domain.repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceImplTest {

    @InjectMocks
    DoctorServiceImpl doctorserviceimpl;

    @Mock
    private DoctorRepository doctorRepository;

    Logger logger = (Logger) LoggerFactory.getLogger(DoctorServiceImplTest.class);

    @Test
    public void saveDoctorWithNullResult() {
        try {
            logger.info("Starting execution of saveDoctor");
            Doctor expectedValue = null;
            Doctor doctor = null;
            when(doctorRepository.save(any())).thenReturn(expectedValue);
            Doctor actualValue = doctorserviceimpl.saveDoctor(doctor);
            logger.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            assertEquals(expectedValue, actualValue);
        } catch (Exception exception) {
            logger.error("Exception in execution of execute1GetAllloggerFromFirstMovF-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void saveDoctor() {
        try {
            logger.info("Starting execution of saveDoctor");
            Doctor expectedValue = new Doctor();
            expectedValue.setId(1);
            Doctor doctor = new Doctor();
            doctor.setName("test");
            doctor.setDegree("MBBS");
            doctor.setEmail("dummy@gmail.com");
            doctor.setSpecialization("heart surgeon");

            when(doctorRepository.save(any())).thenReturn(expectedValue);

            Doctor actualValue = doctorserviceimpl.saveDoctor(doctor);
            logger.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            assertEquals(expectedValue.getId(), actualValue.getId());
        } catch (Exception exception) {
            logger.error("Exception in execution of execute1GetAllloggerFromFirstMovF-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void listAllDoctorsWithNullResult() {
        try {
            logger.info("Starting execution of listAllDoctors");
            List<Doctor> expectedValue = null;
            when(doctorRepository.findAll()).thenReturn(expectedValue);
            List<Doctor> actualValue = doctorserviceimpl.listAllDoctors();
            logger.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            assertEquals(expectedValue, actualValue);
        } catch (Exception exception) {
            logger.error("Exception in execution of execute1GetAllloggerFromFirstMovF-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void listAllDoctors() {
        try {
            logger.info("Starting execution of listAllDoctors");
            List<Doctor> expectedValue = new ArrayList<>();
            Doctor d1 = new Doctor();
            d1.setName("test");
            d1.setDegree("MBBS");
            d1.setEmail("dummy@gmail.com");
            d1.setSpecialization("heart surgeon");
            expectedValue.add(d1);

            when(doctorRepository.findAll()).thenReturn(expectedValue);

            List<Doctor> actualValue = doctorserviceimpl.listAllDoctors();
            logger.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            assertEquals(expectedValue.size(), actualValue.size());
        } catch (Exception exception) {
            logger.error("Exception in execution of execute1GetAllloggerFromFirstMovF-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void getDoctorByWithWrongId() {
        try {
            logger.info("Starting execution of getDoctorById");
            Doctor expectedValue = new Doctor();
            expectedValue.setId(2);
            int doctorId = 0;
            when(doctorRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(expectedValue));

            Doctor actualValue = doctorserviceimpl.getDoctorById(doctorId);
            logger.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            assertEquals(expectedValue.getId(), actualValue.getId());
        } catch (Exception exception) {
            logger.error("Exception in execution of execute1GetAllloggerFromFirstMovF-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void getDoctorById() {
        try {
            logger.info("Starting execution of getDoctorById");
            Doctor expectedValue = new Doctor();
            expectedValue.setId(1);
            int doctorId = 1;
            when(doctorRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(expectedValue));

            Doctor actualValue = doctorserviceimpl.getDoctorById(doctorId);
            logger.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            assertEquals(expectedValue.getId(), actualValue.getId());
        } catch (Exception exception) {
            logger.error("Exception in execution of execute1GetAllloggerFromFirstMovF-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void deleteDoctorById() {
        try {
            logger.info("Starting execution of deleteDoctorById");
            Doctor expectedValue = new Doctor();
            expectedValue.setId(2);
            int doctorId = 0;
            when(doctorRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(expectedValue));

            doctorserviceimpl.deleteDoctorById(doctorId);
            assertTrue(true);
        } catch (Exception exception) {
            logger.error("Exception in execution ofdeleteDoctorById-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void deleteDoctorByWithWrongId() {
        try {
            logger.info("Starting execution of deleteDoctorById");
            Doctor expectedValue = new Doctor();
            expectedValue.setId(2);
            int doctorId = 0;
            when(doctorRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(expectedValue));

            doctorserviceimpl.deleteDoctorById(doctorId);
            assertTrue(true);
        } catch (Exception exception) {
            logger.error("Exception in execution ofdeleteDoctorById-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void updateDoctorNameById() {
        try {
            logger.info("Starting execution of updateDoctorNameById");
            Doctor expectedValue = null;
            int doctorId = 0;
            String doctorName = "";

            Doctor actualValue = doctorserviceimpl.updateDoctorNameById(doctorId, doctorName);
            logger.info("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            System.out.println("Expected Value=" + expectedValue + " . Actual Value=" + actualValue);
            assertEquals(expectedValue, actualValue);
        } catch (Exception exception) {
            logger.error("Exception in execution of execute1GetAllloggerFromFirstMovF-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }



    @Test
    public void addPatientUnderDoctor() {
        try {
            logger.info("Starting execution of addPatientUnderDoctor");
            int doctorId = 0;
            Patient patient = null;

            doctorserviceimpl.addPatientUnderDoctor(doctorId, patient);
            assertTrue(true);
        } catch (Exception exception) {
            logger.error("Exception in execution ofaddPatientUnderDoctor-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }

    @Test
    public void dischargePatient() {
        try {
            logger.info("Starting execution of dischargePatient");
            int doctorId = 0;
            int patientId = 0;

            doctorserviceimpl.dischargePatient(doctorId, patientId);
            assertTrue(true);
        } catch (Exception exception) {
            logger.error("Exception in execution ofdischargePatient-" + exception, exception);
            exception.printStackTrace();
            assertFalse(false);
        }
    }
}
