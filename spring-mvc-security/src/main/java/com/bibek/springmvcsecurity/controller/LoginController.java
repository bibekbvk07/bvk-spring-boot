package com.bibek.springmvcsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "login/login-page";
    }

    //  add request mapping for /access-denied
    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "login/access-denied";
    }

}
