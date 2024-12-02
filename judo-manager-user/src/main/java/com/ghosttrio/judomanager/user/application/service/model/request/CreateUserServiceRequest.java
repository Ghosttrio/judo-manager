package com.ghosttrio.judomanager.user.application.service.model.request;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserRole;

//@ServiceRequest
public record CreateUserServiceRequest(
	String email,
	String nickname,
	String dojoCode,
	UserRole role
) {
}
