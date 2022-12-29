package com.doctorpatient.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "doctors")
public class Doctor extends BaseDomainObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String degree;

    @Column(nullable = false)
    private String specialization;

    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

    public void addPatient(Patient patient) {
        if (patients == null) {
            patients = new ArrayList<>();
        }
        patients.add(patient);
        patient.setDoctor(this);
    }

    public Doctor removePatient(Patient patient)
    {
        patients.remove(patient);
        patient.setDoctor(null);
        return this;
    }
}
