package com.rubincomputers.springboot01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        //return new BCryptPasswordEncoder();


        // Define the plain-text password encoder
//        PasswordEncoder noOpPasswordEncoder = NoOpPasswordEncoder.getInstance();
//
//        // Define the BCrypt password encoder
//        PasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
//
//        // Create a DelegatingPasswordEncoder and register the password encoders
//        Map<String, PasswordEncoder> encoders = new HashMap<>();
//        encoders.put("noop", noOpPasswordEncoder);
//        encoders.put("bcrypt", bcryptPasswordEncoder);
//        DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt", encoders);
//        return passwordEncoder;

        PasswordEncoder passwordEncoderFactories = PasswordEncoderFactories.createDelegatingPasswordEncoder();


        return passwordEncoderFactories;
    }
}
