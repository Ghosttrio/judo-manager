package com.ghosttrio.judomanager.user.application.service;

import com.ghosttrio.judomanager.user.application.port.out.UserClientPort;
import com.ghosttrio.judomanager.user.application.port.out.UserPersistencePort;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateUserService {

    private final LoadUserService loadUserService;
    private final UserClientPort userClientPort;
    private final UserPersistencePort userPersistencePort;
    private final CircuitBreakerFactory circuitBreakerFactory;

    @Transactional
    public void updateStatus(Long userId) {
        UserDomain userDomain = loadUserService.findById(userId);
        userDomain.updateStatus();
        userPersistencePort.save(userDomain);
    }


//    @Transactional
//    public void lastLogin(Long userId) {
//        UserEntity userEntity = loadUserService.findById(userId);
//        userEntity.updateLoginDate();
//    }

    @Transactional
    public void updateNickname(Long userId, String nickname) {
        UserDomain userDomain = loadUserService.findById(userId);
        userDomain.updateNickname(nickname);
        userPersistencePort.save(userDomain);
    }

    @Transactional
    public void update(Long userId, String dojoCode) {

        // 서킷 브레이커 적용 전
//        Long dojoId = findByDojoCode(dojoCode);

        // 서킷 브레이커 적용 후
        CircuitBreaker circuitebreaker = circuitBreakerFactory.create("circuitebreaker");
        Long dojoId = circuitebreaker.run(() -> findByDojoCode(dojoCode), throwable -> 0L);


        UserDomain userDomain = loadUserService.findById(userId);
        userDomain.setDojo(dojoId);
        userPersistencePort.save(userDomain);
    }

    private Long findByDojoCode(String dojoCode) {
        return userClientPort.findDojoByDojoCode(dojoCode).getDojoId();
    }

}
