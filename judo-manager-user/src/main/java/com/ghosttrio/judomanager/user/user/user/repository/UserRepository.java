package com.ghosttrio.judomanager.user.user.user.repository;

import com.ghosttrio.judomanager.user.user.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserQueryRepository {
}
