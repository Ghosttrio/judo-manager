//package com.judomanager.chat.chat;
//
//import com.judomanager.chat.chat.request.CreateChatRoomRequest;
//import com.judomanager.common.exception.JMResponse;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/chat/room")
//@Tag(name = "[Chat API]")
//public class CreateChatRoomController {
//
//    @PostMapping
//    public JMResponse<Void> createChatRoom(@RequestBody CreateChatRoomRequest request){
//        return JMResponse.ok();
//    }
//}
