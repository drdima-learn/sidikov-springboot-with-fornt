package com.rubincomputers.springboot01.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String getLoginPage(Authentication authentication, @RequestParam Map<String, String> queryParams, Model model){
        System.out.println(queryParams);
        if (authentication!=null){
            return "redirect:/";
        }
        if (queryParams.containsKey("error")){
            model.addAttribute("error", "Login or pass failed");
        }
        return "login";
    }
}
