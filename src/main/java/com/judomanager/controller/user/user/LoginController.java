package com.judomanager.controller.user.user;

import com.judomanager.common.JMResponse;
import com.judomanager.common.util.Constant;
import com.judomanager.controller.user.user.request.LoginRequest;
import com.judomanager.controller.user.user.request.RefreshRequest;
import com.judomanager.controller.user.user.response.*;
import com.judomanager.service.user.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "인증 컨트롤러")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class LoginController {

    private final LoginService loginService;

    @Tag(name = "로그인 API")
    @Operation(summary = "카카오 코드를 받아서 액세스 토큰을 발급한다.")
    @PostMapping("/login")
    public JMResponse<SigninResponse> login(@RequestBody LoginRequest request){
        SigninResponse result = loginService.login(request.kakaoCode());
        return JMResponse.ok(result);
    }

    @Tag(name = "토큰 재발급 API")
    @Operation(summary = "카카오 메일 정보와 만료된 액세스 토큰으로 다시 액세스 토큰을 발급한다.")
    @PostMapping("/refresh")
    public JMResponse<String> refresh(@RequestBody RefreshRequest request,
                                      @RequestHeader(Constant.AUTHORIZATION_HEADER) String requestAccessToken){
        String accessToken = loginService.refresh(request.getEmail(), requestAccessToken);

        return JMResponse.ok(accessToken);
    }
}
