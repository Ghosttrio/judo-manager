package com.ghosttrio.judomanager.user.application.service;

import com.ghosttrio.judomanager.user.application.port.out.UserPersistencePort;
import com.ghosttrio.judomanager.user.application.port.out.UserRedisPort;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class WithdrawService {

    private final UserPersistencePort userPersistencePort;
    private final UserRedisPort userRedisPort;

    /**
     *  유저의 개인 정보만 삭제하고 데이터 자체는 유지
     */
    @Transactional
    public void withdraw(Long userId){
        UserDomain userDomain = userPersistencePort.findById(userId);
        deleteTokenInfo(userDomain);
        withdraw(userDomain);
    }

    private void deleteTokenInfo(UserDomain userDomain) {
        String email = userDomain.getUserProfile().getEmail();
        userRedisPort.deleteValues(email);
    }

    private void withdraw(UserDomain userDomain) {
        UserDomain withDrawUser = userDomain.withDrawUser();
        userPersistencePort.save(withDrawUser);
    }
}
