package com.ghosttrio.judomanager.user.application.port.in.impl;

import com.ghosttrio.judomanager.user.adapter.port.in.presentation.model.request.UserRequest.Create.CreateUserServiceRequest;
import com.ghosttrio.judomanager.user.application.service.CreateUserService;
import com.ghosttrio.judomanager.user.common.MonkeySupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseImplTest extends MonkeySupport {

    @InjectMocks
    private CreateUserUseCaseImpl createUserUseCaseImpl;
    @Mock
    private CreateUserService createUserService;

    @Test
    void signup_메서드가_실행되어야_한다() {
        CreateUserServiceRequest request = monkey.giveMeOne(CreateUserServiceRequest.class);
        createUserUseCaseImpl.execute(request);
        verify(createUserService, times(1)).signup(request);
    }

}