package com.ghosttrio.judomanager.user.adapter.port.in.presentation;

import com.ghosttrio.judomanager.user.adapter.port.in.presentation.model.request.UserRequest;
import com.ghosttrio.judomanager.user.application.port.in.*;
import com.ghosttrio.judomanager.user.common.exception.JMResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Tag(name = "[User API]")
public class UpdateUserController {

    private final UpdateNicknameUseCase updateNicknameUseCase;
    private final UpdateDojoUseCase updateDojoUseCase;
    private final UpdateUserStatusUseCase updateUserStatusUseCase;
    private final UpdateUserDanUseCase updateUserDanUseCase;
    private final PromotionUserUseCase promotionUserUseCase;

    @Operation(summary = "유저의 닉네임 정보를 변경합니다.")
    @PatchMapping("/nickname/{userId}")
    public JMResponse<Void> updateNickname(@PathVariable Long userId,
                                           @RequestBody UserRequest.Nickname request) {
        updateNicknameUseCase.execute(userId, request.nickname());
        return JMResponse.ok();
    }

    @Operation(summary = "유저의 도장 정보를 변경합니다.")
    @PatchMapping("/{userId}/dojo")
    public JMResponse<Void> updateDojo(@PathVariable Long userId,
                                       @RequestBody UserRequest.Dojo request) {
        updateDojoUseCase.execute(userId, request.dojoCode());
        return JMResponse.ok();
    }

    @Operation(summary = "유저의 상태 정보를 변경합니다.")
    @PatchMapping("/{userId}/status")
    public JMResponse<Void> updateStatus(@PathVariable Long userId) {
        updateUserStatusUseCase.execute(userId);
        return JMResponse.ok();
    }

    @Operation(summary = "유저의 승단 정보를 특정 단위로 강제 변경합니다.")
    @PatchMapping("/{userId}/dan")
    public JMResponse<Void> updateDan(@NotNull @PathVariable Long userId,
                                      @RequestBody UserRequest.Dan request) {
        updateUserDanUseCase.execute(userId, request.grade(), request.belt());
        return JMResponse.ok();
    }

    @Operation(summary = "유저를 한 단계 승단합니다.")
    @PatchMapping("/{userId}/promotion")
    public JMResponse<Void> promotionUser(@NotNull @PathVariable Long userId) {
        promotionUserUseCase.execute(userId);
        return JMResponse.ok();
    }
}
