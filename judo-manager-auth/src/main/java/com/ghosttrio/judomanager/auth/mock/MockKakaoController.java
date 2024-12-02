package com.ghosttrio.judomanager.auth.mock;

import com.ghosttrio.judomanager.auth.adapter.port.out.feign.KakaoTokenClient;
import com.ghosttrio.judomanager.auth.adapter.port.out.feign.KakaoUserInfoClient;
import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response.KakaoTokenResponse;
import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response.KakaoUserInfoResponse;
import com.ghosttrio.judomanager.auth.common.properties.KakaoProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/auth/mock")
@RequiredArgsConstructor
public class MockKakaoController {

    private final KakaoTokenClient kakaoTokenClient;
    private final KakaoUserInfoClient kakaoUserInfoClient;
    private final KakaoProperties kakaoProperties;

    @GetMapping("/html")
    public String mockHtml() {
        return "first";
    }

    @GetMapping("/oauth")
    public String mockOauth(@RequestParam String code,
                            Model model) {
        KakaoTokenResponse kakaoToken = kakaoTokenClient.getKakaoToken(
                kakaoProperties.getGrant_type(),
                kakaoProperties.getClient_id(),
                kakaoProperties.getRedirect_uri(),
                code
        );
        model.addAttribute("token", kakaoToken.access_token());
        return "second";
    }

    @GetMapping("/info")
    public String userInfo(@RequestParam String code,
                           Model model) {
        KakaoUserInfoResponse kakaoUserInfo = kakaoUserInfoClient.getKakaoUserInfo("Bearer " + code);
        model.addAttribute("userInfo", kakaoUserInfo);
        return "third";
    }

}
