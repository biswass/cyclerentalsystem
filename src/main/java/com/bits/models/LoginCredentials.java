package com.bits.models;

import javax.persistence.*;
import java.io.Serializable;

public class LoginCredentials implements Serializable{

	private static final long serialVersionUID = 1L;

	public LoginCredentials() {}
	private long id;

	private String username;
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
