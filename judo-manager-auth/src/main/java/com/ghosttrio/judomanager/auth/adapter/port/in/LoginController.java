package com.ghosttrio.judomanager.auth.adapter.port.in;

import com.ghosttrio.judomanager.auth.adapter.port.in.model.request.LoginRequest;
import com.ghosttrio.judomanager.auth.application.port.in.LoginUseCase;
import com.ghosttrio.judomanager.auth.common.exception.JMResponse;
import com.ghosttrio.judomanager.auth.security.test.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Tag(name = "[Auth API]")
public class LoginController {

    private final LoginUseCase loginUseCase;

    @Operation(summary = "카카오 인가 코드를 받아서 액세스 토큰을 발급한다.")
    @PostMapping("/login")
    public JMResponse<TokenResponse> login(@RequestBody LoginRequest request) {
        TokenResponse result = loginUseCase.execute(request.kakaoCode());
        return JMResponse.ok(result);
    }
}
