package com.judomanager.controller.user.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {
    @GetMapping("/logout")
    public String test(){
        return "test";
    }
}
