package com.judomanager.infrastructure.feign.kakao.client;

import com.judomanager.infrastructure.config.feign.FeignConfig;
import com.judomanager.infrastructure.feign.kakao.dto.KakaoTokenRequest;
import com.judomanager.infrastructure.feign.kakao.dto.KakaoTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "KakaoTokenClient",
        url = "https://kauth.kakao.com/oauth/token",
        configuration = FeignConfig.class
)
public interface KakaoTokenClient {

    @PostMapping
    KakaoTokenResponse authorize(@RequestParam String client_id,
                                 @RequestParam String client_secret,
                                 @RequestParam String grant_type,
                                 @RequestParam String redirect_uri,
                                 @RequestParam String code);


}
