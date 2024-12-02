package com.ghosttrio.judomanager.user.application.port.in;

import com.ghosttrio.judomanager.user.domain.UserDomain;

public interface LoadUserUseCase {
    UserDomain execute(Long id);
}
