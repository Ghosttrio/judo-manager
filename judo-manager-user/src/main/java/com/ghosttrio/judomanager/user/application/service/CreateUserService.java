package com.ghosttrio.judomanager.user.application.service;

import com.ghosttrio.judomanager.user.adapter.port.in.presentation.model.request.UserRequest.Create.CreateUserServiceRequest;
import com.ghosttrio.judomanager.user.application.port.out.UserPersistencePort;
import com.ghosttrio.judomanager.user.common.exception.ErrorCode;
import com.ghosttrio.judomanager.user.common.exception.JMException;
import com.ghosttrio.judomanager.user.domain.UserAddress;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import com.ghosttrio.judomanager.user.domain.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ghosttrio.judomanager.user.domain.UserAddress.createUserAddress;
import static com.ghosttrio.judomanager.user.domain.UserDomain.generateUserDomain;
import static com.ghosttrio.judomanager.user.domain.UserProfile.createUserProfile;


@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UserPersistencePort userPersistencePort;

    @Transactional
    public void signup(CreateUserServiceRequest request) {
        checkDuplicateEmail(request.email());
        checkDuplicateNickname(request.nickname());

        UserProfile userProfile = generateUserProfile(request);
        UserDomain userDomain = generateUserDomain(userProfile);
        userPersistencePort.save(userDomain);
    }

    private UserProfile generateUserProfile(CreateUserServiceRequest request) {
        UserAddress userAddress = createUserAddress(request.location(), request.latitude(), request.longitude());
        return createUserProfile(request.nickname(), request.email(), request.role(), userAddress);
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
