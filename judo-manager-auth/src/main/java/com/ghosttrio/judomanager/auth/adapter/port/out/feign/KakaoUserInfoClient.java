package com.ghosttrio.judomanager.auth.adapter.port.out.feign;

import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response.KakaoUserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "KakaoUserInfoClient", url = "https://kapi.kakao.com/v2/user/me"
)
public interface KakaoUserInfoClient {

    @GetMapping
    KakaoUserInfoResponse getKakaoUserInfo(@RequestHeader(value = "Authorization") String token);
}
