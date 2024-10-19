package com.ghosttrio.judomanager.user.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestContoller {

    @GetMapping("/api/v1/users")
    public String test() {
        return "test";
    }
}
