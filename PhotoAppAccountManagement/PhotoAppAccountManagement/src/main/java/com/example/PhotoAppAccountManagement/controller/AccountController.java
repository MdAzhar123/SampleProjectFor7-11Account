package com.example.PhotoAppAccountManagement.controller;

import com.example.PhotoAppAccountManagement.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private Environment environment;

    @GetMapping("/status")

    public String status(){
        return "working on port "+environment.getProperty("local.server.port");

    }

    @GetMapping
    public Account getDetails(){
        return new Account("Azhar",1);
    }

}
