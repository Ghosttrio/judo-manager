package com.ghosttrio.judomanager.user.application.service;

import com.ghosttrio.judomanager.user.application.port.out.UserPersistencePort;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadUserService {

    private final UserPersistencePort userPersistencePort;

    public UserDomain findById(Long userId) {
        return userPersistencePort.findById(userId);
    }

    public UserDomain findByEmail(String email) {
        return userPersistencePort.findByEmail(email);
    }

}
