package com.ghosttrio.judomanager.admin.application.port.in.user.impl;

import com.ghosttrio.judomanager.admin.application.service.UpdateUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserBanUseCaseImplTest {

    @Mock
    private UpdateUserService updateUserService;
    @InjectMocks
    private UserBanUseCaseImpl userBanUseCaseImpl;

    @Test
    void 유저_벤_요청_서비스가_호출되어야_한다() {
        Long userId = 1L;
        Mockito.doNothing().when(updateUserService).ban(userId);
        userBanUseCaseImpl.execute(userId);
        verify(updateUserService, times(1)).ban(userId);
    }
}