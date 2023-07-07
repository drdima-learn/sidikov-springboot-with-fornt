package com.rubincomputers.springboot01.controller;

import com.rubincomputers.springboot01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.rubincomputers.springboot01.model.User.from;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public String getUserPage(Model model) {
        //model.addAttribute("userName", "Vasya");
        model.addAttribute("users", from(repository.findAll()));
        return "users";

    }


}
