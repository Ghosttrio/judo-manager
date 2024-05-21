package com.judomanager.service.user;

import com.judomanager.domain.dojo.Dojo;
import com.judomanager.domain.user.User;
import com.judomanager.service.dojo.LoadDojoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UpdateUserService {

    private final LoadUserService loadUserService;
    private final LoadDojoService loadDojoService;

    @Transactional
    public void lastLogin(Long userId){
        User user = loadUserService.findById(userId);
        user.updateLoginDate();
    }

    @Transactional
    public void updateNickname(Long userId, String nickname){
        User user = loadUserService.findById(userId);
        user.setNickname(nickname);
    }

    @Transactional
    public void updateDojo(Long userId, String dojoCode){
        Long dojoId = findByDojoCode(dojoCode);
        User user = loadUserService.findById(userId);
        user.setDojo(dojoId);
    }

    private Long findByDojoCode(String dojoCode){
        Dojo dojo = loadDojoService.findByDojoCode(dojoCode);
        return dojo.getId();
    }



}
