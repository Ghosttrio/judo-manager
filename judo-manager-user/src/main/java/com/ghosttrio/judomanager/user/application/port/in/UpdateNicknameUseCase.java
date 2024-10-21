package com.ghosttrio.judomanager.user.application.port.in;

public interface UpdateNicknameUseCase {
    void execute(Long userId, String nickname);
}
