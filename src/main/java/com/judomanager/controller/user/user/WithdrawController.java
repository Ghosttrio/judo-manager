package com.judomanager.controller.user.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WithdrawController {

    @GetMapping("/withdraw")
    public void withdraw(){

    }
}
