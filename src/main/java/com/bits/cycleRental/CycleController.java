package com.bits.cycleRental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bits.models.Cycle;
import com.bits.services.CycleService;

@RestController
public class CycleController {
	
	@Autowired
	CycleService cycleService;
        
	/*@GetMapping
	@RequestMapping("/{id}")
    Cycle getCycle(@PathVariable("id") String id) {
    	long cycleId = Long.parseLong(id);
    	Cycle cycle = cycleService.getCycle(cycleId);
        return cycle;
    }*/
	
	@RequestMapping(value="/cycle/{id}", method=RequestMethod.GET)
    Cycle getCycle(@PathVariable("id") String id) {
		long cycleId = Long.parseLong(id);
    	Cycle cycle = cycleService.getCycle(cycleId);
        return cycle;
    	/*int cycleId = Integer.parseInt(id);
    	Cycle cycle = new Cycle(cycleId, "Montra");
        return cycle;*/
    }
    
    @PostMapping
    @RequestMapping("/cycle") 
    void addCycle(@RequestBody Cycle cycle) {
    	cycleService.addCycle(cycle);
    }
    
    @RequestMapping(value="/cycle/{id}", method=RequestMethod.DELETE)
    void removeCycle(@PathVariable("id") String id) {
    	long cycleId = Long.parseLong(id);
    	cycleService.removeCycle(cycleId);
    }

}
