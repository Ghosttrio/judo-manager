package com.ghosttrio.judomanager.user.application.port.out;

import com.ghosttrio.judomanager.user.domain.UserDomain;


public interface UserPersistencePort {
    void save(UserDomain userDomain);

    UserDomain findById(Long id);

    void deleteById(Long id);

    UserDomain findByEmail(String email);

    boolean isDuplicateUser(String email);

    boolean isDuplicateNickname(String nickname);
}
