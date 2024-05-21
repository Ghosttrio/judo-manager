package com.judomanager.controller.user.user.event;

import com.judomanager.repository.user.UserRepository;
import com.judomanager.service.user.UpdateUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class LoginEventListener {

    private final UpdateUserService updateUserService;

    @EventListener
    public void LastLoginDateListener(LastLoginDateEvent request){
        updateUserService.lastLogin(request.userId());
    }
}
