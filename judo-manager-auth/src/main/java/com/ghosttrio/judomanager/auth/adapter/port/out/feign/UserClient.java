package com.ghosttrio.judomanager.auth.adapter.port.out.feign;

import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.request.CreateUserRequest;
import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response.LoginUserInfoResponse;
import com.ghosttrio.judomanager.auth.security.config.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(
        name = "UserClient", url = "http://localhost:8000/api/v1/users"
)
public interface UserClient {

    @GetMapping("/{kakaoCode}")
    LoginUserInfoResponse loadUserInfo(@PathVariable String kakaoCode);

    @GetMapping("/userId/{userId}")
    UserInfo loadUserByUsername(@PathVariable String userId);

    @PostMapping
    void save(@RequestBody CreateUserRequest request);

    @GetMapping("/email/{email}")
    Optional<UserInfo> findByEmail(@PathVariable String email);

    @GetMapping("/nickname/{nickname}")
    Optional<UserInfo> findByNickname(@PathVariable String nickname);
}
