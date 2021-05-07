package com.zunde.userManagement.User;

import com.zunde.userManagement.registration.RegistrationRequest;
import com.zunde.userManagement.registration.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
public class UserRegistrationController {
    @Autowired
    RegistrationService registrationService;

    @PostMapping
    public String registration(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
    @RequestMapping(path = "/login")
    public String logged(){
        return "logged in";
    }
}
