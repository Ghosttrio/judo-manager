package com.ghosttrio.judomanager.auth.adapter.port.out.feign;

import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.request.CreateUserRequest;
import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response.LoginUserInfoResponse;
import com.ghosttrio.judomanager.auth.application.port.out.UserClientPort;
import com.ghosttrio.judomanager.auth.security.config.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserClientAdapter implements UserClientPort {

    private final UserClient userClient;

    @Override
    public LoginUserInfoResponse loadUserInfo(String kakaoCode) {
        return userClient.loadUserInfo(kakaoCode);
    }

    @Override
    public UserInfo loadUserByUsername(String userId) {
        return userClient.loadUserByUsername(userId);
    }

    @Override
    public void signup(CreateUserRequest request) {
        userClient.save(request);
    }

    @Override
    public Optional<UserInfo> loadUserByEmail(String email) {
        return userClient.findByEmail(email);
    }

    @Override
    public Optional<UserInfo> loadUserByNickname(String nickname) {
        return userClient.findByNickname(nickname);
    }
}
