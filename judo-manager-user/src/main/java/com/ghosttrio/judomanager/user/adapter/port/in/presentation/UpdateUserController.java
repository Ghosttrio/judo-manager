package com.ghosttrio.judomanager.user.adapter.port.in.presentation;

import com.ghosttrio.judomanager.user.adapter.port.in.presentation.model.request.UserRequest;
import com.ghosttrio.judomanager.user.application.port.in.UpdateDojoUseCase;
import com.ghosttrio.judomanager.user.application.port.in.UpdateNicknameUseCase;
import com.ghosttrio.judomanager.user.common.exception.JMResponse;
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

    @PatchMapping("/nickname/{userId}")
    public JMResponse<Void> setNickname(@PathVariable Long userId,
                                        @RequestBody UserRequest.Nickname request){
        updateNicknameUseCase.execute(userId, request.nickname());
        return JMResponse.ok();
    }

    @PatchMapping("/dojo/{userId}")
    public JMResponse<Void> setDojo(@PathVariable Long userId,
                                    @RequestBody UserRequest.Dojo request){
        updateDojoUseCase.execute(userId, request.dojoCode());
        return JMResponse.ok();
    }

}
