package com.ghosttrio.judomanager.user.user;

import com.judomanager.api.security.UserId;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.user.domain.User;
import com.judomanager.domain.user.service.LoadUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Tag(name = "[User API]")
public class UserController {

    private final LoadUserService loadUserService;

    @GetMapping
    public JMResponse<User> loadUser(@UserId Long userId){
        User result = loadUserService.findById(userId);
        return JMResponse.ok(result);
    }

}
