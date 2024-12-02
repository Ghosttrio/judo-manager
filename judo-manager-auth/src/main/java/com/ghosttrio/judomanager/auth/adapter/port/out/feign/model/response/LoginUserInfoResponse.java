package com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response;

public record LoginUserInfoResponse(
        Long id,
        String email,
        String role
) {
}
