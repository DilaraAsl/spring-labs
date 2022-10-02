package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class ProfileController {
    @RequestMapping("profile")
    String getProfile(Model model){
        Profile profile=new Profile("mail@mail","888-777-5555","John","Doe","jdoe",
                LocalDateTime.now());
        model.addAttribute("profile",profile);
        return "/profile/profile-info";
    }
}
