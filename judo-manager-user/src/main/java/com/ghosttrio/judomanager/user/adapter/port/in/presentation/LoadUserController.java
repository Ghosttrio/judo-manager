package com.ghosttrio.judomanager.user.adapter.port.in.presentation;

import com.ghosttrio.judomanager.user.application.port.in.LoadUserUseCase;
import com.ghosttrio.judomanager.user.common.exception.JMResponse;
import com.ghosttrio.judomanager.user.domain.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Tag(name = "[User API]")
public class LoadUserController {

    private final LoadUserUseCase loadUserUseCase;

    @GetMapping("/{id}")
    public JMResponse<User> loadUser(@PathVariable Long id){
        User result = loadUserUseCase.execute(id);
        return JMResponse.ok(result);
    }

}
