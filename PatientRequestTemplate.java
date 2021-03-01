package hospital.patients.Payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PatientRequestTemplate {
    private String patientCode;
    private String firstName;
    private String lastName;
    private Integer patientAge;
    private Integer patientWeight;
    private Float temperature;
    private String patientBloodGroup;
    @JsonProperty
    private boolean isChronic;
}
