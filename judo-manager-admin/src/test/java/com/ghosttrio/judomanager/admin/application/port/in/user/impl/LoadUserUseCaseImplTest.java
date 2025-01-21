package com.ghosttrio.judomanager.admin.application.port.in.user.impl;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.user.model.User;
import com.ghosttrio.judomanager.admin.application.service.LoadUserService;
import com.ghosttrio.judomanager.admin.common.MonkeySupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LoadUserUseCaseImplTest extends MonkeySupport {

    @Mock
    private LoadUserService loadUserService;

    @InjectMocks
    private LoadUserUseCaseImpl loadUserUseCaseImpl;

    @Test
    void 모든_유저_조회_서비스가_호출되어야_한다() {
        List<User> users = monkey.giveMe(User.class, 3);
        when(loadUserService.findAll()).thenReturn(users);
        loadUserUseCaseImpl.execute();
        verify(loadUserService, times(1)).findAll();
    }
}