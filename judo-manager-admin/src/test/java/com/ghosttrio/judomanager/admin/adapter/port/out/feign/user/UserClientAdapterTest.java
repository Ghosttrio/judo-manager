package com.ghosttrio.judomanager.admin.adapter.port.out.feign.user;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.user.model.User;
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

@ExtendWith(MockitoExtension.class)
class UserClientAdapterTest extends MonkeySupport {

    @Mock
    private UserClient userClient;
    @InjectMocks
    private UserClientAdapter userClientAdapter;

    @Test
    void 유저_전체_정보_요청이_성공해야_한다() {
        List<User> users = monkey.giveMe(User.class, 3);
        when(userClient.findAll()).thenReturn(users);
        userClientAdapter.findAll();
        verify(userClient, times(1)).findAll();
    }

    @Test
    void 유저_상태정보_수정_요청이_성공해야_한다() {
        Long userId = 1L;
        doNothing().when(userClient).updateUserStatus(userId);
        userClientAdapter.updateUserStatus(userId);
        verify(userClient, times(1)).updateUserStatus(userId);
    }
}