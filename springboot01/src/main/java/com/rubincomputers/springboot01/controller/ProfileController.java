package com.rubincomputers.springboot01.controller;

import com.rubincomputers.springboot01.dto.UserDTO;
import com.rubincomputers.springboot01.model.User;
import com.rubincomputers.springboot01.security.details.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    @GetMapping(name = "/")
    public String getProfilePage(Authentication authentication, Model model){
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        User user = details.getUser();
        model.addAttribute("user", UserDTO.from(user));
        return "profile";
    }
}
