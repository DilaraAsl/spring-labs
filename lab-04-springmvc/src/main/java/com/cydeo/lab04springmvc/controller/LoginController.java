package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
@RequestMapping("login")
    String getLoginInfo(Model model){
    Login login=new Login("email@email.com","1234124241","no-way-home");
     model.addAttribute("email",login.getEmail());
     model.addAttribute("phoneNumber",login.getPhoneNumber());
     model.addAttribute("loginMessage",login.getPassword());
        return "/login/login-info";
    }
}
