package com.ts.shipment_marketplace.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ts.shipment_marketplace.DTO.LoginRequest;
import com.ts.shipment_marketplace.Entity.User;
import com.ts.shipment_marketplace.Repository.UserRepository;
import com.ts.shipment_marketplace.security.JwtUtil;
import com.ts.shipment_marketplace.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	 private final AuthService authService;
	 
	 @Autowired
	 UserRepository userRepository;
	 @Autowired
	 BCryptPasswordEncoder passwordEncoder;
	 @Autowired
	 JwtUtil jwtUtil;
	 
	    @PostMapping("/register")
	    public User register(@RequestBody User user){

	        return authService.register(user);
	    }
	
	    @PostMapping("/login")
	    public Map<String,String> login(@RequestBody LoginRequest request){
	    	
	    	User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
	    		               
	    	 if(passwordEncoder.matches(request.getPassword(),user.getPassword())) {
	    		 
	    		 String token =jwtUtil.generateToken(user.getUsername());
	    		 
	    		 return Map.of("token",token);
	    	 }
	    	 
	    	 throw new RuntimeException(
	    	            "Invalid Credentials");
	    	
	    	
	    }
	
}
