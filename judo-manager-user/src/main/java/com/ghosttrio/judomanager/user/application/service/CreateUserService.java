package com.ghosttrio.judomanager.user.application.service;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserRole;
import com.ghosttrio.judomanager.user.application.port.out.UserPersistencePort;
import com.ghosttrio.judomanager.user.common.exception.ErrorCode;
import com.ghosttrio.judomanager.user.common.exception.JMException;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UserPersistencePort userPersistencePort;

    /**
     *  회원 가입할 때는 dojoCode를 받지 말고, 가입 후에 도장을 등록하는 방식으로 진행
     */
    @Transactional
    public void signup(String email, String nickname, UserRole role){
        checkDuplicateEmail(email);
        checkDuplicateNickname(nickname);
        UserDomain userDomain = UserDomain.create(email, nickname, role);
        userPersistencePort.save(userDomain);
    }

    private void checkDuplicateEmail(String email) {
        boolean isDuplicate = userPersistencePort.isDuplicateUser(email);
        if (isDuplicate) {
            throw new JMException(ErrorCode.NICKNAME_DUPLICATE);
        }
    }

    private void checkDuplicateNickname(String nickname) {
        boolean isDuplicate = userPersistencePort.isDuplicateNickname(nickname);
        if (isDuplicate) {
            throw new JMException(ErrorCode.EMAIL_DUPLICATE);
        }
    }

}
