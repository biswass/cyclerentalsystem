package com.bits.services;

import com.bits.Exceptions.InvalidCredentialsException;
import com.bits.dao.UserDAO;
import com.bits.models.LoginCredentials;
import com.bits.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UserDAO userDAO;

    public void authenticate(LoginCredentials loginCredentials) throws InvalidCredentialsException {
        User user = userDAO.findByEmail(loginCredentials.getUsername());
        if(user == null ) {
            throw new InvalidCredentialsException("Invalid credentials");
        }
    }
}
