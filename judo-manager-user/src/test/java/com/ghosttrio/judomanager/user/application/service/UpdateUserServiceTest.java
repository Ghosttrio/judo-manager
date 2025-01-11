package com.ghosttrio.judomanager.user.application.service;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserState;
import com.ghosttrio.judomanager.user.application.port.out.UserClientPort;
import com.ghosttrio.judomanager.user.application.port.out.UserPersistencePort;
import com.ghosttrio.judomanager.user.common.MonkeySupport;
import com.ghosttrio.judomanager.user.common.exception.JMException;
import com.ghosttrio.judomanager.user.domain.Grade;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateUserServiceTest extends MonkeySupport {

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
    void 활성화_상태_유저가_비활성화_되어야_한다() {
        UserDomain userDomain = monkey.giveMeBuilder(UserDomain.class)
                .set("state", UserState.ACTIVATED)
                .sample();
        when(loadUserService.findById(any(Long.class))).thenReturn(userDomain);
        updateUserService.updateStatus(userDomain.getId());
        verify(userPersistencePort).save(userDomain);
    }

    @ParameterizedTest
    @ValueSource(strings = {"DEACTIVATED", "DELETED"})
    void 유저의_상태가_활성화_상태가_아니면_에러가_발생한다(UserState state) {
        UserDomain userDomain = monkey.giveMeBuilder(UserDomain.class)
                .set("state", state)
                .sample();
        when(loadUserService.findById(any(Long.class))).thenReturn(userDomain);
        Exception exception = assertThrows(JMException.class, () -> updateUserService.updateStatus(userDomain.getId()));
        assertEquals("유저의 비활성화는 활성화 상태의 유저만 요청할 수 있습니다.", exception.getMessage());
    }

    @Test
    void 유저_아이디값을_입력하면_유저_승급이_되어야_한다() {
        UserDomain userDomain = monkey.giveMeBuilder(UserDomain.class)
                .set("grade", Grade.DAN1)
                .sample();
        when(loadUserService.findById(any(Long.class))).thenReturn(userDomain);
        Grade grade = updateUserService.promotionGrade(userDomain.getId());
        assertEquals(Grade.DAN2, grade);
    }

    @Test
    void 단의_등급이_10단인_경우는_승급할_수_없다() {
        UserDomain userDomain = monkey.giveMeBuilder(UserDomain.class)
                .set("grade", Grade.DAN10)
                .sample();
        when(loadUserService.findById(any(Long.class))).thenReturn(userDomain);
        assertThrows(JMException.class, () -> updateUserService.promotionGrade(userDomain.getId()));
    }


}
