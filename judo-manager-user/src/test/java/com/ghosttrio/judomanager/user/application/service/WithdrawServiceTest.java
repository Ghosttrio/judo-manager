package com.ghosttrio.judomanager.user.application.service;

import com.ghosttrio.judomanager.user.application.port.out.UserPersistencePort;
import com.ghosttrio.judomanager.user.application.port.out.UserRedisPort;
import com.ghosttrio.judomanager.user.common.MonkeySupport;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import com.ghosttrio.judomanager.user.domain.UserState;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WithdrawServiceTest extends MonkeySupport {

    @Mock
    private UserPersistencePort userPersistencePort;
    @Mock
    private UserRedisPort userRedisPort;
    @InjectMocks
    private WithdrawService withdrawService;

    @Test
    void 삭제_대상회원의_토큰_정보_삭제와_유저의_상대가_DELETED로_수정되어야_한다() {
        UserDomain userDomain = monkey.giveMeBuilder(UserDomain.class)
                .set("state", UserState.ACTIVATED)
                .sample();
        UserDomain withDrawUser = userDomain.withDrawUser();

        when(userPersistencePort.findById(any(Long.class))).thenReturn(userDomain);
        doNothing().when(userRedisPort).deleteValues(userDomain.getUserProfile().getEmail());

        withdrawService.withdrawUser(userDomain.getId());

        assertEquals(UserState.DELETED, withDrawUser.getState());
        verify(userPersistencePort, times(1)).save(withDrawUser);
    }
}