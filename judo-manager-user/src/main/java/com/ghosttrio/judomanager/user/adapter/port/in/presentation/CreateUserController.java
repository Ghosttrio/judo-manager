package com.ghosttrio.judomanager.user.adapter.port.in.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghosttrio.judomanager.user.adapter.port.in.presentation.model.request.UserRequest;
import com.ghosttrio.judomanager.user.application.port.in.CreateUserUseCase;
import com.ghosttrio.judomanager.user.common.exception.JMResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Tag(name = "[User API]")
public class CreateUserController {

	private final CreateUserUseCase createUserUseCase;

	@Operation(description = "User 를 생성합니다.")
	@PostMapping("/signup")
	public JMResponse<Void> signup(@RequestBody UserRequest.Create request) {
		createUserUseCase.execute(request.toService());
		return JMResponse.ok();
	}
}
