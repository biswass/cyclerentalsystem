package com.bits.cycleRental;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HealthController {

    @RequestMapping("/health")
    String healthCheck() {
        return "Service is healthy!";
    }
    
    /*@RequestMapping("/cycle/{id}")
    Cycle getCycle(@PathVariable("id") String id) {
    	int cycleId = Integer.parseInt(id);
    	Cycle cycle = new Cycle(cycleId, "Montra");
        return cycle;
    }*/

}
