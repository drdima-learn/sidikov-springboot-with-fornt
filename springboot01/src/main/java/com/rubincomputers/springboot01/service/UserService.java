package com.rubincomputers.springboot01.service;

import com.rubincomputers.springboot01.controller.ExceptionInfoHandlerRestController;
import com.rubincomputers.springboot01.form.UserForm;
import com.rubincomputers.springboot01.model.Role;
import com.rubincomputers.springboot01.model.State;
import com.rubincomputers.springboot01.model.User;
import com.rubincomputers.springboot01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;



    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user){
        String hashPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long userId) {
        User user = null;
        try {
            user = repository.findById(userId).orElseThrow(() -> new RuntimeException("userId not found"));
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        finally {
            return user;
        }
    }

//    public User save(User user) {
//        User created=null;
//        try {
//            created = repository.save(user);
//        } catch (DataIntegrityViolationException e){
//            ExceptionInfoHandlerRestController.conflict("/rest/users/",e);
//        }
//        return created;
//    }
}
