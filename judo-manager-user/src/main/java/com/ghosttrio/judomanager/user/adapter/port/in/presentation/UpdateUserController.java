package com.ghosttrio.judomanager.user.adapter.port.in.presentation;

import com.ghosttrio.judomanager.user.adapter.port.in.presentation.model.request.UserRequest;
import com.ghosttrio.judomanager.user.application.port.in.UpdateDojoUseCase;
import com.ghosttrio.judomanager.user.application.port.in.UpdateNicknameUseCase;
import com.ghosttrio.judomanager.user.application.port.in.UpdateUserDanUseCase;
import com.ghosttrio.judomanager.user.application.port.in.UpdateUserStatusUseCase;
import com.ghosttrio.judomanager.user.common.exception.JMResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    // 유저의 승단 결과 업데이트
    @Operation(summary = "유저의 승단 정보를 특정 단위로 변경합니다.")
    @PatchMapping("/{userId}/dan")
    public JMResponse<Void> updateDan(@PathVariable Long userId,
                                      @RequestBody UserRequest.Dan request) {
        updateUserDanUseCase.execute(request.grade());
        return JMResponse.ok();
    }

    @Operation(summary = "유저를 승단합니다.")
    @PatchMapping("/{userId}/promotion")
    public JMResponse<Void> promotionUser(@PathVariable Long userId) {
        return JMResponse.ok();
    }
}
