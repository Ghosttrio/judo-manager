package com.judomanager.domain.repository.user;

import com.judomanager.domain.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserQueryRepository {
}
