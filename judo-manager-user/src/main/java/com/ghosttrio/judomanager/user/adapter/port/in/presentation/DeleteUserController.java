package com.ghosttrio.judomanager.user.adapter.port.in.presentation;

import com.ghosttrio.judomanager.user.application.service.WithdrawService;
import com.ghosttrio.judomanager.user.common.exception.JMResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Tag(name = "[User API]")
public class DeleteUserController {

    private final WithdrawService withdrawService;

    @GetMapping("/withdraw/{userId}")
    public JMResponse<Void> withdraw(@PathVariable Long userId){
        withdrawService.withdraw(userId);
        return JMResponse.ok();
    }
}
