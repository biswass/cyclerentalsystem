package com.bits.dao;

import org.springframework.stereotype.Repository;

import com.bits.models.Reservation;

@Repository
public class ReservationDAO extends AbstractJPADAO<Reservation> {// implements IFooDAO{

   public ReservationDAO(){
      setClazz(Reservation.class );
   }
}
