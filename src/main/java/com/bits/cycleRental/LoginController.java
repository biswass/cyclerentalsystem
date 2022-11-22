package com.bits.cycleRental;

import com.bits.models.Cycle;
import com.bits.models.LoginCredentials;
import com.bits.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping
    @RequestMapping("/login")
    void login(@RequestBody LoginCredentials loginCredentials) {
        authenticationService.authenticate(loginCredentials);
    }

    /*@GetMapping("/home")
    public String home() {
        return "Displaying the home page contents";
    }*/

}
