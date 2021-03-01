package hospital.patients.Controller;

import hospital.patients.Model.ApplicationUser;
import hospital.patients.Service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping("/users")
public class ApplicationUserController {
    @Autowired
    ApplicationUserService applicationUserService;

@PostMapping("/sign-up")
    public ApplicationUser signUp(ApplicationUser user){
        return applicationUserService.signUp(user);
    }
}
