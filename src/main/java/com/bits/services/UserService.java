package com.bits.services;

import com.bits.models.User;

public interface UserService {
	
	User getUserById(long id);
	
	void addBalance(long id, double amount);
	
}
