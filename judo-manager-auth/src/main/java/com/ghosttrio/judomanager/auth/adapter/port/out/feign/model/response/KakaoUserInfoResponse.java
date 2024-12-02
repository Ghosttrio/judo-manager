package com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response;

import lombok.Data;

@Data
public class KakaoUserInfoResponse {

    private String id;
    private Properties properties;

    private KakaoAccount kakaoAccount;

    @Data
    public static class Properties {
        private String nickname;
    }

    @Data
    public static class KakaoAccount {
        private Profile profile;
        private String email;
        private String phoneNumber;
        private String name;
        @Data
        public static class Profile {
            private String profileImageUrl;
        }
    }

}