package com.ghosttrio.judomanager.auth.adapter.port.in;//package com.ghosttrio.judomanager.user.user;

import com.ghosttrio.judomanager.auth.application.port.in.LogoutUseCase;
import com.ghosttrio.judomanager.auth.application.service.RedisService;
import com.ghosttrio.judomanager.auth.common.exception.JMResponse;
import com.ghosttrio.judomanager.auth.domain.CustomUserDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Tag(name = "[User API]")
public class LogoutController {

    private final LogoutUseCase logoutUseCase;

    @Operation(summary = "헤더 값의 accessToken 정보를 이용하여 로그아웃합니다.")
    @PostMapping("/logout")
    public JMResponse<Void> logout(@RequestHeader("Authorization") String accessToken){
        logoutUseCase.execute(accessToken);
        return JMResponse.ok();
    }

}
