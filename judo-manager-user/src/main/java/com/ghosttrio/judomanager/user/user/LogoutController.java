package com.ghosttrio.judomanager.user.user;

import com.judomanager.api.security.CustomUserDetails;
import com.judomanager.api.security.jwt.AuthenticationLoader;
import com.judomanager.domain.security.jwt.JwtResolver;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.infrastructure.redis.RedisService;
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

    private final AuthenticationLoader authenticationLoader;
    private final JwtResolver jwtResolver;
    private final RedisService redisService;

    @Operation(summary = "헤더 값의 accessToken 정보를 이용하여 로그아웃합니다.")
    @PostMapping("/logout")
    public JMResponse<Void> logout(@RequestHeader("Authorization") String requestAccessToken){
        Authentication authentication = authenticationLoader.getAuthentication(jwtResolver.resolveToken(requestAccessToken));
        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
        redisService.deleteValues(principal.email());
        return JMResponse.ok();
    }

}
