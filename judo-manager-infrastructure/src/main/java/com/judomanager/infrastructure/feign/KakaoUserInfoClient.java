package com.judomanager.infrastructure.feign;

import com.judomanager.infrastructure.config.feign.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import static org.springframework.cloud.openfeign.security.OAuth2AccessTokenInterceptor.AUTHORIZATION;

@FeignClient(
        name = "KakaoUserInfoClient",
        url = "https://kapi.kakao.com/v2/user/me",
        configuration = FeignConfig.class
)
public interface KakaoUserInfoClient {

    @GetMapping
    KakaoUserInfoResponse getUserInfo(@RequestHeader(AUTHORIZATION) String token);

}
