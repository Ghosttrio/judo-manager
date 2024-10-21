package com.ghosttrio.judomanager.user.adapter.port.in.presentation;

import com.ghosttrio.judomanager.user.adapter.port.in.presentation.model.request.UserRequest;
import com.ghosttrio.judomanager.user.application.port.in.CreateUserUseCase;
import com.ghosttrio.judomanager.user.common.exception.JMResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Tag(name = "[User API]")
public class CreateUserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    public JMResponse<Void> createUser(@RequestBody UserRequest.Create request) {
        createUserUseCase.execute(
                request.email(),
                request.nickname(),
                request.dojoCode(),
                request.role());
        return JMResponse.ok();
    }
}
