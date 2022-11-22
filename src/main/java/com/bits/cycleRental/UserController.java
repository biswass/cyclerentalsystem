package com.bits.cycleRental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bits.services.UserService;

@RestController("/user")
public class UserController {
	
	@Autowired
	UserService userService;
          
    @PostMapping
    @RequestMapping("/user/{id}/balance/{topupAmount}") 
    void addBalance(@PathVariable("id") String id, @PathVariable("topupAmount") String topupAmount) {
    	long userId = Long.parseLong(id);
    	double amount = Double.parseDouble(topupAmount);
    	userService.addBalance(userId, amount);
    }

}
