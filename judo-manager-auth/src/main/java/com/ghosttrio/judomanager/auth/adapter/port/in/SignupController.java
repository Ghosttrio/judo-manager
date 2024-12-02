package com.ghosttrio.judomanager.auth.adapter.port.in;

import com.ghosttrio.judomanager.auth.adapter.port.in.model.request.LoginRequest;
import com.ghosttrio.judomanager.auth.application.port.in.SignupUseCase;
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
public class SignupController {

    private final SignupUseCase signupUseCase;

    @Operation(summary = "카카오 계정으로 회원가입을 수행한다.")
    @PostMapping("/signup")
    public JMResponse<Void> signup(@RequestBody LoginRequest request) {
        signupUseCase.execute(request.kakaoCode());
        return JMResponse.ok();
    }
}
