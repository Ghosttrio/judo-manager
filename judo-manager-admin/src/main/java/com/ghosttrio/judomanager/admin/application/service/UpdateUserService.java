package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.application.port.out.UserClientPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserService {

    private final UserClientPort userClientPort;

    @Transactional
    public void ban(Long userId) {
        userClientPort.updateUserStatus(userId);
    }

}
