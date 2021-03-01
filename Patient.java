package hospital.patients.Model;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name ="PATIENTS")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @NotBlank(message = "Patient code cannot be left blank")
    @Column(name = "PATIENT_CODE")
    private String code;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "WEIGHT")
    private Integer weight;
    @Column(name = "TEMPERATURE")
    private Float temperature;
    @Column(name = "BLOOD_GROUP")
    private String bloodGroup;
    @Column(name = "DATE_ADMITTED")
    private Date dateAdmitted;
    @Column(name = "DATE_DISCHARGED")
    private Date dateDischarged;
    @JsonProperty
    @Column(name = "IS_CHRONIC")
    private boolean isChronic;

}
