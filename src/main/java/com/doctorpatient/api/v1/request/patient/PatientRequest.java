package com.doctorpatient.api.v1.request.patient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientRequest {
    @NotNull(message = "{constraints.NotEmpty.message}")
    private String name;

    @NotNull(message = "{constraints.NotEmpty.message}")
    private String disease;

    @NotNull(message = "{constraints.NotEmpty.message}")

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
}
