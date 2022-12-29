package com.doctorpatient.domain.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="patients")
public class Patient extends BaseDomainObject{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String disease;

	private Date dateOfBirth;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private Doctor doctor;

	public Patient() {
	}

	public Patient(String name, String disease, Date dateOfBirth, Doctor doctor) {
		this.name = name;
		this.disease = disease;
		this.dateOfBirth = dateOfBirth;
		this.doctor = doctor;
	}
	
}
