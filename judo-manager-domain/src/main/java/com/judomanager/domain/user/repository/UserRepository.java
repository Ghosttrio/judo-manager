package com.judomanager.domain.user.repository;

import com.judomanager.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserQueryRepository {
}
