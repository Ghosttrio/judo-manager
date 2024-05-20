package com.judomanager.repository.user;


import com.judomanager.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface UserQueryRepository {

    List<User> findAllUserByDojoId(Long dojoId);

    Optional<User> findByEmail(String email);
}
