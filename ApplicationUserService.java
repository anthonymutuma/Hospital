package hospital.patients.Service;

import hospital.patients.DAO.ApplicationUserRepository;
import hospital.patients.Model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    BCryptPasswordEncoder  bCryptPasswordEncoder;

    public ApplicationUser signUp(ApplicationUser user){
        user.setUsername(user.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return applicationUserRepository.save(user);
    }
}
