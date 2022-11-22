package com.bits.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cycle")
public class Cycle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Cycle() { }
	
	public Cycle(long id, String modelName) {
		this.id = id;
		this.modelName = modelName;
	}
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name="model_name")
	private String modelName;
	
	@OneToOne(mappedBy = "cycle")
	private Reservation reservation;
	
	public long getCycleId() {
		return id;
	}
	public void setCycleId(long cycleId) {
		this.id = cycleId;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
}
