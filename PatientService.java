package hospital.patients.Service;

import hospital.patients.DAO.PatientRepository;
import hospital.patients.Model.Patient;
import hospital.patients.Payload.PatientRequestTemplate;
import hospital.patients.Payload.PatientResponseTemplate;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

   public List<Patient> getAll(){
       return patientRepository.findAll();
    }

//    public Optional<Patient> getById(Long id){
//       return patientRepository.findById(id);
//    }

    public Patient getById(Long id) throws NotFoundException {
       Patient patient = patientRepository.findById(id).orElseThrow(()-> new NotFoundException("Patient not found for : "+id));
        return patient;
   }

    public PatientResponseTemplate save(PatientRequestTemplate patientRequestTemplate){
        PatientResponseTemplate patientResponseTemplate = new PatientResponseTemplate();
       Patient patient = new Patient();
       patient.setCode(patientRequestTemplate.getPatientCode());
       patient.setFirstName(patientRequestTemplate.getFirstName());
       patient.setLastName(patientRequestTemplate.getLastName());
       patient.setAge(patientRequestTemplate.getPatientAge());
       patient.setWeight(patientRequestTemplate.getPatientWeight());
       patient.setTemperature(patientRequestTemplate.getTemperature());
       patient.setBloodGroup(patientRequestTemplate.getPatientBloodGroup());
       patient.setDateAdmitted(new Date());
       patient.setChronic(patientRequestTemplate.isChronic());

       Patient savedPatient = patientRepository.save(patient);

        patientResponseTemplate.setId(savedPatient.getId());
        patientResponseTemplate.setName(savedPatient.getFirstName()+"   "+savedPatient.getLastName());

       return patientResponseTemplate;
    }

    public Patient update(PatientRequestTemplate patientRequestTemplate, Long id) throws NotFoundException{
//       Optional<Patient> patient = patientRepository.findById(id);
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new NotFoundException("Patient not found for : "+id));
        Patient updatedPatient;
       if (patient !=null){
           patient.setCode(patientRequestTemplate.getPatientCode());
           patient.setFirstName(patientRequestTemplate.getFirstName());
           patient.setLastName(patientRequestTemplate.getLastName());
           patient.setAge(patientRequestTemplate.getPatientAge());
           patient.setWeight(patientRequestTemplate.getPatientWeight());
           patient.setTemperature(patientRequestTemplate.getTemperature());
           patient.setBloodGroup(patientRequestTemplate.getPatientBloodGroup());
           patient.setChronic(patientRequestTemplate.isChronic());
          updatedPatient = patientRepository.save(patient);
       } else {
           throw new RuntimeException("Patient not found for id :" +id);
       }
       return updatedPatient ;
    }

    public  void deleteById(Long id){
       Optional<Patient> patient = patientRepository.findById(id);
       if (patient.isPresent()) {
           patientRepository.delete(patient.get());
       }
       else{
           throw new RuntimeException ("Patient not found for id :" +id);
       }
    }

}
