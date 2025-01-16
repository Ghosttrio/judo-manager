package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.repository.command;

import com.ghosttrio.judomanager.user.domain.Belt;
import com.ghosttrio.judomanager.user.domain.Grade;

public interface UserCommandRepository {
    void updateUserDan(Long userId, Grade grade, Belt belt);
}
