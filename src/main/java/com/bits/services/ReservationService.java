package com.bits.services;

import com.bits.models.Reservation;

public interface ReservationService {
	void createReservation(Reservation reservation);
	
	void removeReservation(long reservationId);
	
	Reservation getReservationById(long id);
	
	Reservation getReservationByCycleId(long cycleId);
	
}
