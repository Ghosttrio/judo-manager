package com.ghosttrio.judomanager.user.application.port.out;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserEntity;
import com.ghosttrio.judomanager.user.domain.User;

import java.util.Optional;

public interface UserPort {
    void save();
    User findById(Long id);
    void deleteById(Long id);
}
