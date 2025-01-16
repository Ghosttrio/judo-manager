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
    void 닉넴과_이메일이_중복되지_않으면_회원가입에_성공_해야_한다() {
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