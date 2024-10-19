//package com.ghosttrio.judomanager.user.user;
//
//import com.ghosttrio.judomanager.user.user.request.RegisterRequest;
//import com.judomanager.api.security.UserId;
//import com.judomanager.common.exception.JMResponse;
//import com.judomanager.domain.user.service.UpdateUserService;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/registers")
//@Tag(name = "[User API]")
//public class RegisterController {
//
//    private final UpdateUserService updateUserService;
//
//    @PatchMapping("/nickname")
//    public JMResponse<Void> setNickname(@UserId Long userId,
//                                        @RequestBody RegisterRequest.Nickname request){
//        updateUserService.updateNickname(userId, request.nickname());
//        return JMResponse.ok();
//    }
//
//    @PatchMapping("/dojo")
//    public JMResponse<Void> setDojo(@UserId Long userId,
//                                    @RequestBody RegisterRequest.Dojo request){
//        updateUserService.updateDojo(userId, request.dojoCode());
//        return JMResponse.ok();
//    }
//
//}
