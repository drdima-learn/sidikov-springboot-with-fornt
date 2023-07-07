package com.rubincomputers.springboot01.controller.rest;

import com.rubincomputers.springboot01.dto.TokenDTO;
import com.rubincomputers.springboot01.form.UserForm;
import com.rubincomputers.springboot01.model.Token;
import com.rubincomputers.springboot01.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestLoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/rest/login")
    public ResponseEntity<TokenDTO> login(@RequestBody UserForm userForm){
        return ResponseEntity.ok(loginService.login(userForm));
    }
}
