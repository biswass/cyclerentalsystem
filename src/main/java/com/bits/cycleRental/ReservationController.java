package com.bits.cycleRental;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bits.models.Reservation;
import com.bits.services.ReservationService;

@RestController
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@PostMapping
    @RequestMapping("/reservation") 
    void createReservation(@RequestBody Reservation reservation) {
    	reservationService.createReservation(reservation);
    }
	
	@RequestMapping(value="/reservation/{id}", method=RequestMethod.DELETE)
    void releaseReservation(@PathVariable("id") String id) {
    	long reservationId = Long.parseLong(id);
    	reservationService.removeReservation(reservationId);
    }
	
}
