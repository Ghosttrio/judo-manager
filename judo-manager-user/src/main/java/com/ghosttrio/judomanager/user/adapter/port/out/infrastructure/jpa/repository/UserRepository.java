package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.repository;


import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserQueryRepository, UserCommandRepository {
}
