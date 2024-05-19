package com.judomanager.repository.user;


import com.judomanager.domain.user.User;

import java.util.List;

public interface UserQueryRepository {

    List<User> findAllUserByDojoId(Long dojoId);
}
