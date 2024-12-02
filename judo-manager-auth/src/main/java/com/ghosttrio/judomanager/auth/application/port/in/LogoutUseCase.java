package com.ghosttrio.judomanager.auth.application.port.in;

public interface LogoutUseCase {
    void execute(String accessToken);
}
