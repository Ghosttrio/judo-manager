package com.ghosttrio.judomanager.user.application.port.in;

public interface UpdateDojoUseCase {
    void execute(Long userId, String dojoCode);
}
