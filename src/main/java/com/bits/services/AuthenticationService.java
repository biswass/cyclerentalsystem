package com.bits.services;

import com.bits.models.LoginCredentials;

public interface AuthenticationService {
    public void authenticate(LoginCredentials loginCredentials);

}