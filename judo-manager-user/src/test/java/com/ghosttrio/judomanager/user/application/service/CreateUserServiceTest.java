package com.ghosttrio.judomanager.user.application.service;

import com.ghosttrio.judomanager.user.adapter.port.in.presentation.model.request.UserRequest.Create.CreateUserServiceRequest;
import com.ghosttrio.judomanager.user.application.port.out.UserPersistencePort;
import com.ghosttrio.judomanager.user.common.MonkeySupport;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateUserServiceTest extends MonkeySupport {

    @InjectMocks
    private CreateUserService createUserService;
    @Mock
    private UserPersistencePort userPersistencePort;

    @Test
    void signup() {
        //given
        CreateUserServiceRequest request = monkey.giveMeOne(CreateUserServiceRequest.class);
        when(userPersistencePort.isDuplicateUser(request.email())).thenReturn(false);
        when(userPersistencePort.isDuplicateNickname(request.nickname())).thenReturn(false);
        //when
        createUserService.signup(request);
        //then
        verify(userPersistencePort, times(1)).save(any(UserDomain.class));
    }
}