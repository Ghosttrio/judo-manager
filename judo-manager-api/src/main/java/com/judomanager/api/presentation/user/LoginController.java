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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Slf4j
@Tag(name = "[User API]")
public class LoginController {

    private final LoginService loginService;

    /**
     * 로그인 로직
     * 1. 회원가입하면 id와 암호화된 패스워드 저장
     * 2. 로그인 하면 아이디, 패스워드 검증
     * 3. 확인되면 액세스 토큰, 리프레시 토큰 발급
     * 4. 액세스 토큰으로 리턴, 리프레시 토큰은 redis에 저장
     * 5. 액세스 토큰을 모든 api 요청에 사용
     * 6. 액세스 토큰 만료 시 액세스 토큰으로 리프레시 요청
     *      - 리프레시 토큰이 있으면 새로운 액세스 토큰 발급
     *      - 리프레시 토큰도 만료되면 다시 로그인하게 페이지 이동
     * 7. 로그아웃 시 리프레시 토큰 삭제
     */


    @Operation(summary = "카카오 코드를 받아서 액세스 토큰을 발급한다.")
    @PostMapping("/login")
    public JMResponse<SigninResponse> login(@RequestBody LoginRequest request){
        SigninResponse result = loginService.login(request.kakaoCode());
        return JMResponse.ok(result);
    }

    @Operation(summary = "카카오 메일 정보와 만료된 액세스 토큰으로 다시 액세스 토큰을 발급한다.")
    @PostMapping("/refresh")
    public JMResponse<AccessTokenResponse> refresh(@RequestBody RefreshRequest request,
                                                   @RequestHeader(JudoMangerStatic.AUTHORIZATION_HEADER) String requestAccessToken){
        AccessTokenResponse result = loginService.refresh(request.email(), requestAccessToken);
        return JMResponse.ok(result);
    }
}
