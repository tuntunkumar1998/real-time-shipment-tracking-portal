package com.ts.shipment_marketplace.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ts.shipment_marketplace.Entity.User;
import com.ts.shipment_marketplace.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	    private final UserRepository userRepository;
	    private final PasswordEncoder encoder;
	
	    public User register(User user){

	        user.setPassword(encoder.encode(user.getPassword()));
	        return userRepository.save(user);
	    }
}
