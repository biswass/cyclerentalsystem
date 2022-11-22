package com.bits.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bits.dao.UserDAO;
import com.bits.models.User;
import com.bits.models.Wallet;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	public User getUserById(long id) {
		// lookup any reservation against this user id
		return userDAO.findById(id).get();
	}
	
	@Transactional
	@Override
	public
	void addBalance(long id, double amount) {
		User user = getUserById(id);
		Wallet userWallet = user.getWallet();
		double currBalance = userWallet.getBalance();
		userWallet.setBalance(currBalance+amount);
	}
}
