package com.ghosttrio.judomanager.user.application.service;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.feign.Dojo;
import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserEntity;
import com.ghosttrio.judomanager.user.application.port.out.UserClientPort;
import com.ghosttrio.judomanager.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UpdateUserService {

    private final LoadUserService loadUserService;
    private final UserClientPort userClientPort;


//    @Transactional
//    public void lastLogin(Long userId) {
//        UserEntity userEntity = loadUserService.findById(userId);
//        userEntity.updateLoginDate();
//    }

    @Transactional
    public void updateNickname(Long userId, String nickname) {
        User user = loadUserService.findById(userId);
        user.setNickname(nickname);
    }

    @Transactional
    public void update(Long userId, String dojoCode) {
        Long dojoId = findByDojoCode(dojoCode);
        User user = loadUserService.findById(userId);
        user.setDojo(dojoId);
    }

    private Long findByDojoCode(String dojoCode) {
        Dojo dojoByDojoCode = userClientPort.findDojoByDojoCode(dojoCode)
                .orElseThrow();
        return dojoByDojoCode.getDojoId();
    }


}
