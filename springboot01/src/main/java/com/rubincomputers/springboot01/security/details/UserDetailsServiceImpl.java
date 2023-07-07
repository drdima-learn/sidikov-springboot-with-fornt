package com.rubincomputers.springboot01.security.details;

import com.rubincomputers.springboot01.model.User;
import com.rubincomputers.springboot01.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = repository.findOneByLogin(login);
        //return new UserDetailsImpl(user.orElseThrow(()->new UsernameNotFoundException(login + "user not found")));

        UserDetails userDetails = null;
        try {
            userDetails = new UserDetailsImpl(user.orElseThrow(() -> new UsernameNotFoundException(login + "user not found")));
        } catch (UsernameNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return userDetails;


    }
}
