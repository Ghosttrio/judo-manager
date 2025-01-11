package com.ghosttrio.judomanager.user.application.service;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserState;
import com.ghosttrio.judomanager.user.application.port.out.UserClientPort;
import com.ghosttrio.judomanager.user.application.port.out.UserPersistencePort;
import com.ghosttrio.judomanager.user.common.exception.JMException;
import com.ghosttrio.judomanager.user.domain.Belt;
import com.ghosttrio.judomanager.user.domain.Grade;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import com.ghosttrio.judomanager.user.domain.UserDomain.PromotionResult;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ghosttrio.judomanager.user.common.exception.ErrorCode.DAN_PROMOTION_BAD_REQUEST;
import static com.ghosttrio.judomanager.user.common.exception.ErrorCode.USER_STATE_BAD_REQUEST;

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
        validateUserState(userDomain.getState());
        userDomain.userDeactivate();
        userPersistencePort.save(userDomain);
    }

    private void validateUserState(UserState state) {
        if (state != UserState.ACTIVATED) {
            throw new JMException(USER_STATE_BAD_REQUEST);
        }
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
        UserDomain userDomain = loadUserService.findById(userId);
        validateUserDan(userDomain.getGrade());
        PromotionResult promotionResult = userDomain.promotionGrade();
        Grade promotionGrade = promotionResult.grade();
        Belt promotionBelt = promotionResult.belt();
        userPersistencePort.updateUserDan(userId, promotionGrade, promotionBelt);
        // todo 알림 메시지 보내기
        return promotionGrade;
    }

    private void validateUserDan(Grade grade) {
        if (Grade.DAN10 == grade) throw new JMException(DAN_PROMOTION_BAD_REQUEST);
    }
}
