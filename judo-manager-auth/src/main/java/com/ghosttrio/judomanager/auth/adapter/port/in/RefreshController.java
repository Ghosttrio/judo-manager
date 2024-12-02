package com.ghosttrio.judomanager.auth.adapter.port.in;

import com.ghosttrio.judomanager.auth.adapter.port.in.model.request.RefreshRequest;
import com.ghosttrio.judomanager.auth.application.port.in.RefreshUseCase;
import com.ghosttrio.judomanager.auth.common.exception.JMResponse;
import com.ghosttrio.judomanager.auth.security.test.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Tag(name = "[User API]")
public class RefreshController {

    private final RefreshUseCase refreshUseCase;

    @Operation(summary = "카카오 메일 정보와 만료된 액세스 토큰으로 다시 액세스 토큰을 발급한다.")
    @PostMapping("/refresh")
    public JMResponse<TokenResponse> refresh(@RequestBody RefreshRequest request,
                                             @RequestHeader("Authorization") String accessToken){
        TokenResponse result = refreshUseCase.execute(request.email(), accessToken);
        return JMResponse.ok(result);
    }
}
