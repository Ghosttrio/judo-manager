package com.ghosttrio.judomanager.user.application.port.in.impl;

import com.ghosttrio.judomanager.user.application.service.LoadUserService;
import com.ghosttrio.judomanager.user.common.MonkeySupport;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import com.ghosttrio.judomanager.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoadUserUseCaseImplTest extends MonkeySupport {

    @InjectMocks
    private LoadUserUseCaseImpl LoadUserUseCaseImpl;
    @Mock
    private LoadUserService loadUserService;
    @Mock
    private UserMapper userMapper;

    @Test
    void signup_메서드가_실행되어야_한다() {
        UserDomain userDomain = monkey.giveMeOne(UserDomain.class);
        when(loadUserService.findById(any(Long.class))).thenReturn(userDomain);
        LoadUserUseCaseImpl.execute(1L);
        verify(userMapper, times(1)).toLoadUserResponse(userDomain);
    }

}