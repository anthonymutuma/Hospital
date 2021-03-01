package hospital.patients.Controller;

import hospital.patients.Model.Patient;
import hospital.patients.Payload.PatientRequestTemplate;
import hospital.patients.Payload.PatientResponseTemplate;
import hospital.patients.Service.PatientService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hospital")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getPatients(){
       return patientService.getAll();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatient (@PathVariable Long id) throws NotFoundException {
        return patientService.getById(id);
    }

    @PostMapping("/patient")
    public ResponseEntity<?> addPatient(@RequestBody PatientRequestTemplate patientRequestTemplate){

        PatientResponseTemplate data =  patientService.save(patientRequestTemplate);

            return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PutMapping("/patients/{id}")
    public Patient updatePatient(@RequestBody PatientRequestTemplate patientRequestTemplate, @PathVariable Long id)
            throws NotFoundException {
        patientService.update(patientRequestTemplate,id);
        return patientService.update(patientRequestTemplate,id);
    }

    @DeleteMapping("/patients/{id}")
    public void deletePatient(@PathVariable Long id){
        patientService.deleteById(id);
    }

}
