package com.judomanager.controller.mock;

import com.judomanager.common.properties.KakaoProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mock")
public class MockController {

    private final KakaoProperties kakaoProperties;


    @GetMapping
    public String mock(@RequestParam String code){
        return "ok";
    }

    @Operation(summary = "프론트 프로젝트를 실행하지 않고 카카오 로그인 주소 발급합니다.")
    @Tag(name = "[Mock] 카카오 로그인 주소 발급 API")
    @GetMapping("/login")
    public String loadKakaoLoginUrl() {
        return "https://kauth.kakao.com/oauth/authorize?client_id="+kakaoProperties.getClient_id()
                +"&redirect_uri="+"http://localhost:8080/mock"+"&response_type=code";
    }
}
