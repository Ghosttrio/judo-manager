package com.judomanager.domain.user.repository;




import com.judomanager.domain.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserQueryRepository {

    List<User> findAllUserByDojoId(Long dojoId);

    Optional<User> findByEmail(String email);
}
