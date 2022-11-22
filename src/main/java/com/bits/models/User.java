package com.bits.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	public User() { }
	
	public User(long id, String email, String password, Reservation reservation, Wallet wallet) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.reservation = reservation;
		this.wallet = wallet;
	}



	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	
	@OneToOne(mappedBy = "user")
	private Reservation reservation;
	
	@OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
	private Wallet wallet;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
}
