package com.judomanager.controller.user.user;

import com.judomanager.common.JMResponse;
import com.judomanager.common.util.Constant;
import com.judomanager.controller.user.user.kakao.KakaoTokenClient;
import com.judomanager.controller.user.user.kakao.KakaoTokenRequest;
import com.judomanager.controller.user.user.request.LoginRequest;
import com.judomanager.controller.user.user.request.RefreshRequest;
import com.judomanager.controller.user.user.response.*;
import com.judomanager.service.user.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public JMResponse<SigninResponse> login(@RequestBody LoginRequest request){
        SigninResponse result = loginService.login(request.kakaoCode());
        return JMResponse.ok(result);
    }

    @PostMapping("/refresh")
    public JMResponse<String> refresh(@RequestBody RefreshRequest request,
                                                    @RequestHeader(Constant.AUTHORIZATION_HEADER) String requestAccessToken){
        String accessToken = loginService.refresh(request.getEmail(), requestAccessToken);

        return JMResponse.ok(accessToken);
    }
}
