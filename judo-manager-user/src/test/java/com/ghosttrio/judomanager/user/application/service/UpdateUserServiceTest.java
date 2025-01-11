package com.ghosttrio.judomanager.user.application.service;

import com.ghosttrio.judomanager.user.application.port.out.UserClientPort;
import com.ghosttrio.judomanager.user.application.port.out.UserPersistencePort;
import com.ghosttrio.judomanager.user.common.exception.JMException;
import com.ghosttrio.judomanager.user.domain.Grade;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static com.ghosttrio.judomanager.user.common.exception.ErrorCode.DAN_PROMOTION_BAD_REQUEST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateUserServiceTest {

    @Mock
    private LoadUserService loadUserService;
    @Mock
    private UserClientPort userClientPort;
    @Mock
    private UserPersistencePort userPersistencePort;
    @Mock
    private CircuitBreakerFactory circuitBreakerFactory;
    @InjectMocks
    private UpdateUserService updateUserService;

    @Test
    void 유저_아이디값을_입력하면_유저_승급이_되어야_한다() {
        Long userId = 1L;
        when(userClientPort.findUserGrade(any(Long.class))).thenReturn(Grade.DAN2);
        Grade grade = updateUserService.promotionGrade(userId);
        assertEquals(Grade.DAN3, grade);
    }

    @Test
    void 단의_등급이_10단인_경우는_승급할_수_없다() {
        Long userId = 1L;
        when(userClientPort.findUserGrade(any(Long.class))).thenReturn(Grade.DAN10);
        assertThrows(JMException.class, () -> updateUserService.promotionGrade(userId));
    }




}
