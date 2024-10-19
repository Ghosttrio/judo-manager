package com.ghosttrio.judomanager.dojo.dojo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/v1/dojos")
    public String tesT() {
        return "ok";
    }
}
