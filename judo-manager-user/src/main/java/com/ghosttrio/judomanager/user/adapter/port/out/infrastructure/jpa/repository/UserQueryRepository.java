package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.repository;


import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserQueryRepository {

    List<UserEntity> findAllUserByDojoId(Long dojoId);

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByNickname(String nickname);
}
