package com.judomanager.api.controller.feign;

import com.judomanager.api.controller.user.user.response.KakaoTokenResponse;
import com.judomanager.common.common.config.feign.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "KakaoTokenClient",
        url = "https://kauth.kakao.com/oauth/token",
        configuration = FeignConfig.class
)
public interface KakaoTokenClient {

    @PostMapping(consumes = "application/json")
    KakaoTokenResponse authorize(@RequestBody KakaoTokenRequest request);


}
