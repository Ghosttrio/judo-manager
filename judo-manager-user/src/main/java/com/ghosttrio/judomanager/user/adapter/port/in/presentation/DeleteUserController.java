package com.ghosttrio.judomanager.user.adapter.port.in.presentation;

import com.ghosttrio.judomanager.user.application.port.in.WithdrawUseCase;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import com.ghosttrio.judomanager.user.application.service.WithdrawService;
import com.ghosttrio.judomanager.user.common.exception.JMResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Tag(name = "[User API]")
public class DeleteUserController {

	private final WithdrawUseCase withdrawUseCase;

	@Operation(description = "User 정보를 삭제하고 해당 User의 토큰 정보를 삭제합니다.")
	@DeleteMapping("/withdraw/{userId}")
	public JMResponse<Void> withdraw(@PathVariable Long userId) {
		withdrawUseCase.execute(userId);
		return JMResponse.ok();
	}
}
