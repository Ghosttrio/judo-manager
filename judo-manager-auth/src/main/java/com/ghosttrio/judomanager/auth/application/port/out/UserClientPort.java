package com.ghosttrio.judomanager.auth.application.port.out;


import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.request.CreateUserRequest;
import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response.LoginUserInfoResponse;
import com.ghosttrio.judomanager.auth.security.config.UserInfo;

import java.util.Optional;

public interface UserClientPort {
    LoginUserInfoResponse loadUserInfo(String kakaoCode);

    UserInfo loadUserByUsername(String userId);

    void signup(CreateUserRequest request);

    Optional<UserInfo> loadUserByEmail(String email);

    Optional<UserInfo> loadUserByNickname(String nickname);
}
