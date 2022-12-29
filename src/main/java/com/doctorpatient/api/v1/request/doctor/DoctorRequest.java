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

    @NotNull(message = "{constraints.NotEmpty.message}")
    private String name;

    @NotNull(message = "{constraints.NotEmpty.message}")
    private String email;

    @NotNull(message = "{constraints.NotEmpty.message}")
    private String degree;

    @NotNull(message = "{constraints.NotEmpty.message}")
    private String specialization;

}
