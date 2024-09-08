package com.judomanager.api.presentation.user;

import com.judomanager.api.presentation.user.request.LoginRequest;
import com.judomanager.api.presentation.user.request.RefreshRequest;
import com.judomanager.domain.security.jwt.response.AccessTokenResponse;
import com.judomanager.domain.security.jwt.response.SigninResponse;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.common.util.JudoMangerStatic;
import com.judomanager.domain.user.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.judomanager.common.util.JudoMangerStatic.AUTHORIZATION_HEADER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Tag(name = "[User API]")
public class LoginController {

    private final LoginService loginService;

    @Operation(summary = "카카오 코드를 받아서 액세스 토큰을 발급한다.")
    @PostMapping("/login")
    public JMResponse<SigninResponse> login(@RequestBody LoginRequest request){
        SigninResponse result = loginService.login(request.kakaoCode());
        return JMResponse.ok(result);
    }

    @Operation(summary = "카카오 메일 정보와 만료된 액세스 토큰으로 다시 액세스 토큰을 발급한다.")
    @PostMapping("/refresh")
    public JMResponse<AccessTokenResponse> refresh(@RequestBody RefreshRequest request,
                                                   @RequestHeader(AUTHORIZATION_HEADER) String requestAccessToken){
        AccessTokenResponse result = loginService.refresh(request.email(), requestAccessToken);
        return JMResponse.ok(result);
    }
}
