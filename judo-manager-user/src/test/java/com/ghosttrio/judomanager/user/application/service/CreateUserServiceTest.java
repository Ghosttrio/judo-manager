package com.ghosttrio.judomanager.user.application.service;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserRole;
import com.ghosttrio.judomanager.user.application.port.out.UserPersistencePort;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateUserServiceTest {

    @InjectMocks
    private CreateUserService createUserService;
    @Mock
    private UserPersistencePort userPersistencePort;

    @Test
    void signup() {
        //given
        String email = "testEmail";
        String nickname = "testNick";
        UserRole role = UserRole.MASTER;
        when(userPersistencePort.isDuplicateUser(email)).thenReturn(false);
        when(userPersistencePort.isDuplicateNickname(nickname)).thenReturn(false);
        //when
        createUserService.signup(email, nickname, role);
        //then
        verify(userPersistencePort, times(1)).save(any(UserDomain.class));
    }
}