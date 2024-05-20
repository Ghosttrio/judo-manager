package com.judomanager.controller.mock;

import com.judomanager.controller.user.user.kakao.KakaoProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MockController {


    @GetMapping("/mock")
    public String mock(){
        return "ok";
    }
}
