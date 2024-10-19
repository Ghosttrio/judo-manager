//package com.ghosttrio.judomanager.user.user.event;
//
//import com.judomanager.domain.user.service.UpdateUserService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//@RequiredArgsConstructor
//public class LoginEventListener {
//
//    private final UpdateUserService updateUserService;
//
//    @EventListener
//    public void LastLoginDateListener(LastLoginDateEvent request){
//        updateUserService.lastLogin(request.userId());
//    }
//}
