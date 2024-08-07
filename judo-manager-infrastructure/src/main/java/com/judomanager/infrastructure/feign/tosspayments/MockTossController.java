package com.judomanager.infrastructure.feign.tosspayments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MockTossController {

    @GetMapping("/test")
    public String test(){
        return "test/checkout";
    }

    @GetMapping("/success")
    public String success(){
        return "test/success";
    }

    @GetMapping("/fail")
    public String fail(){
        return "test/fail";
    }
}
