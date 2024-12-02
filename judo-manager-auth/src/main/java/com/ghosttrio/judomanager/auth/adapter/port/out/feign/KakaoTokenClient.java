package com.ghosttrio.judomanager.auth.adapter.port.out.feign;

import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response.KakaoTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "KakaoTokenClient", url = "https://kauth.kakao.com/oauth/token"
)
public interface KakaoTokenClient {
    @PostMapping
    KakaoTokenResponse getKakaoToken(@RequestParam String grant_type,
                                     @RequestParam String client_id,
                                     @RequestParam String redirect_uri,
                                     @RequestParam String code);
}
