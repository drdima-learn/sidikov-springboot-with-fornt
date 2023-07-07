package com.rubincomputers.springboot01.controller;

import com.rubincomputers.springboot01.form.UserForm;
import com.rubincomputers.springboot01.model.User;
import com.rubincomputers.springboot01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @Autowired
    UserService service;

    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup";
    }

//    @PostMapping("/signup")
//    public String postUser(User user) {
//        System.out.println(user);
//        repository.save(user);
//        return "redirect:/users";
//    }

    @PostMapping("/signup")
    public String signUp(UserForm userForm) {
        System.out.println(userForm);
        service.save(User.from(userForm));
        return "redirect:/";
    }
}
