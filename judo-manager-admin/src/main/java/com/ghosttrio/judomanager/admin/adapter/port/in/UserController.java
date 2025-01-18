package com.ghosttrio.judomanager.admin.adapter.port.in;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.user.model.User;
import com.ghosttrio.judomanager.admin.application.port.in.user.LoadUserUseCase;
import com.ghosttrio.judomanager.admin.application.port.in.user.UserBanUseCase;
import com.ghosttrio.judomanager.admin.config.exception.JMResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admins/users")
@Tag(name = "[ADMIN API]")
public class UserController {

    private final LoadUserUseCase loadUserUseCase;
    private final UserBanUseCase userBanUseCase;

    @Operation(summary = "유도 매니저에 등록된 모든 회원을 조회한다.")
    @GetMapping
    public JMResponse<List<User>> loadAllUser() {
        List<User> result = loadUserUseCase.execute();
        return JMResponse.ok(result);
    }

    @Operation(summary = "특정 회원을 비활성화(벤) 상태로 만든다.")
    @PatchMapping("/{userId}")
    public JMResponse<Void> banUser(@PathVariable Long userId) {
        userBanUseCase.execute(userId);
        return JMResponse.ok();
    }

}
