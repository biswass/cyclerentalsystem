package com.bits.services;

import java.util.Date;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bits.Exceptions.InsufficientBalanceException;
import com.bits.Exceptions.InvalidReservationException;
import com.bits.Exceptions.ReservationExistsException;
import com.bits.constants.GlobalConstants;
import com.bits.dao.ReservationDAO;
import com.bits.models.Bill;
import com.bits.models.Cycle;
import com.bits.models.Payment;
import com.bits.models.PaymentStatus;
import com.bits.models.Reservation;
import com.bits.models.User;
import com.bits.models.Wallet;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	ReservationDAO reservationDAO;
	
	@Autowired
	UserService userService;
	
	@Override
	@Transactional
	public void createReservation(Reservation reservation) {
		// check if any reservation is present
		Cycle cycle = reservation.getCycle();
		Reservation existingReservation = getReservationByCycleId(cycle.getCycleId());
		if(existingReservation != null) {
			throw new ReservationExistsException("Cycle " + cycle.getCycleId()+" is already reserved");
		}
		// create initial bill
		Bill bill = new Bill(new Payment(PaymentStatus.PENDING, GlobalConstants.basePayment, new Date()));
		
		// build reservation and persist in DB
		User user = userService.getUserById(reservation.getUser().getId());
		
		/*if(user.getWallet().getBalance() < GlobalConstants.basePayment) {
			throw new InsufficientBalanceException("Wallet does not have sufficient balance. Please add required balance");
		}*/
		
		Reservation newReservation = new Reservation(cycle,user,bill);
		newReservation.setBill(bill);
		newReservation.setUser(user);
		newReservation.setDueDate(reservation.getDueDate());
		newReservation.setCycle(cycle);
		reservationDAO.create(newReservation);
	}
	
	@Override
	@Transactional
	public void removeReservation(long id) {
		// delete reservation from DB
		// check if any reservation is present
		Reservation existingReservation = getReservationById(id);
		if(existingReservation == null) {
			throw new InvalidReservationException("Reservation does not exist");
		}
		
		// compute bill
		Date billingStartTime = existingReservation.getBill().getPayment().getCreationDate();
		Date currTime = new Date();
		long reservedDuration = currTime.getTime() - billingStartTime.getTime();
		long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(reservedDuration);
		double preBookingAmount = existingReservation.getBill().getPayment().getAmount();
		double billedAmount = preBookingAmount + (diffInMinutes/10)*2;
		
		// make payment
		Wallet userWallet = existingReservation.getUser().getWallet();
		double balanceAfterReservation = userWallet.getBalance()-billedAmount;
		
		if(balanceAfterReservation < 0) {
			throw new InsufficientBalanceException("Wallet does not have sufficient balance. Please add required balance");
		}
		
		// if sufficient balance exists, deduct the same and update the payment status
		userWallet.setBalance(balanceAfterReservation);
		Payment payment = existingReservation.getBill().getPayment();
		payment.setStatus(PaymentStatus.PAID);
		
		// validate payment is made
		/*PaymentStatus paymentStatus = existingReservation.getBill().getPayment().getStatus();
		if(paymentStatus == PaymentStatus.PENDING) {
			throw new PendingPaymentException("Payment is pending");
		}*/
		
		// remove the reservation from the DB
		reservationDAO.deleteById(id);
	}
	
	@Override
	public
	Reservation getReservationById(long id) {
		// lookup any reservation against this cycle id
		return reservationDAO.findOne(id);
	}
	
	@Override
	public Reservation getReservationByCycleId(long cycleId) {
		// lookup any reservation against this cycle id
		List<Reservation> reservations = reservationDAO.findAll();
		for(Reservation reservation: reservations) {
			if(reservation.getCycle().getCycleId() == cycleId)
				return reservation;
		}
		return null;
	}
}
