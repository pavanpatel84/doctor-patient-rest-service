package com.doctorpatient.api.v1.request.doctor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoctorRequest {

    @NotNull(message = "name filed shouldn't empty or null")
    private String name;

    @NotNull(message = "email filed shouldn't empty or null")
    private String email;

    @NotNull(message = "degree filed shouldn't empty or null")
    private String degree;

    @NotNull(message = "specialization filed shouldn't empty or null")
    private String specialization;

}
