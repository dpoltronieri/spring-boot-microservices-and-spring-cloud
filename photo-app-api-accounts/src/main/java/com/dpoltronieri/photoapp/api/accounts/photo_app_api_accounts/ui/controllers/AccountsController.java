package com.dpoltronieri.photoapp.api.accounts.photo_app_api_accounts.ui.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class AccountsController {

    @GetMapping("/status/check")
    public String status(){
        return "Alive";
    }
}