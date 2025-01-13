package com.ghosttrio.judomanager.user.application.port.in;

import com.ghosttrio.judomanager.user.domain.Belt;
import com.ghosttrio.judomanager.user.domain.Grade;

public interface UpdateUserDanUseCase {
    void execute(Long userId, Grade grade, Belt belt);
}
