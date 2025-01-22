package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.application.port.out.UserClientPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateUserServiceTest {

    @Mock
    private UserClientPort userClientPort;
    @InjectMocks
    private UpdateUserService updateUserService;

    @Test
    void 유저_벤이_성공해야_한다() {
        Long userId = 1L;
        doNothing().when(userClientPort).updateUserStatus(userId);
        updateUserService.ban(userId);
        verify(userClientPort, times(1)).updateUserStatus(userId);
    }
}