package com.judomanager.api.presentation.user;

import com.judomanager.api.security.UserId;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.user.service.WithdrawService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class WithdrawController {

    private final WithdrawService withdrawService;

    @GetMapping("/withdraw")
    public JMResponse<Void> withdraw(@UserId Long userId){
        withdrawService.withdraw(userId);
        return JMResponse.ok();
    }
}
