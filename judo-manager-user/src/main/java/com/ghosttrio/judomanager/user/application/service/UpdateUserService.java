package com.ghosttrio.judomanager.user.application.service;

import com.ghosttrio.judomanager.user.application.port.out.UserClientPort;
import com.ghosttrio.judomanager.user.application.port.out.UserPersistencePort;
import com.ghosttrio.judomanager.user.common.exception.JMException;
import com.ghosttrio.judomanager.user.domain.Grade;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ghosttrio.judomanager.user.common.exception.ErrorCode.DAN_PROMOTION_BAD_REQUEST;

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

    @Transactional
    public void updateNickname(Long userId, String nickname) {
        UserDomain userDomain = loadUserService.findById(userId);
        userDomain.changeUserNickname(nickname);
        userPersistencePort.save(userDomain);
    }

    @Transactional
    public void update(Long userId, String dojoCode) {
        CircuitBreaker circuitbreaker = circuitBreakerFactory.create("userUpdateCB");
        Long dojoId = circuitbreaker.run(() -> findByDojoCode(dojoCode), throwable -> 0L);

        UserDomain userDomain = loadUserService.findById(userId);
        userDomain.setDojo(dojoId);
        userPersistencePort.save(userDomain);
    }

    private Long findByDojoCode(String dojoCode) {
        return userClientPort.findDojoByDojoCode(dojoCode).getDojoId();
    }

    @Transactional
    public Grade promotionGrade(Long userId) {
        Grade grade = validateUserDan(userId);
        Grade promotinedGrade = grade.promotion();
        userPersistencePort.updateUserDan(userId, promotinedGrade);
        // todo 알림 메시지 보내기
        return promotinedGrade;
    }

    private Grade validateUserDan(Long userId) {
        Grade grade = userClientPort.findUserGrade(userId);
        if (Grade.DAN10 == grade) throw new JMException(DAN_PROMOTION_BAD_REQUEST);
        return grade;
    }
}
