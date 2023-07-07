package com.rubincomputers.springboot01.controller.rest;

import com.rubincomputers.springboot01.controller.ExceptionInfoHandlerRestController;
import com.rubincomputers.springboot01.dto.UserDTO;
import com.rubincomputers.springboot01.exception.ErrorInfo;
import com.rubincomputers.springboot01.form.UserForm;
import com.rubincomputers.springboot01.model.User;
import com.rubincomputers.springboot01.repository.UserRepository;
import com.rubincomputers.springboot01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
public class RestUserController {

    private static final String REST_URL = "/rest/users";
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService service;

    @GetMapping("/rest/users")
    public List<User> getUsers(){
        return service.findAll();
    }

    @GetMapping("/rest/users/{userId}")
    public User getUsers(@PathVariable Long userId){
        return service.findById(userId);
    }

    @PostMapping(value = "/rest/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(HttpServletRequest req,  @RequestBody UserForm userForm){

        User newUser=null;
        try {
            newUser = service.save(User.from(userForm));
        } catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ExceptionInfoHandlerRestController.conflict(req, e));
        }
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(UserDTO.from(newUser));

    }
}
