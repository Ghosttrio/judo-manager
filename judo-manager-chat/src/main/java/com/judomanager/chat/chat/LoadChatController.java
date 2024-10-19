//package com.judomanager.chat.chat;
//
//import com.judomanager.common.exception.JMResponse;
//import com.judomanager.chat.domain.chat.domain.Chat;
//import com.judomanager.chat.domain.chat.service.LoadChatService;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/chat")
//@Tag(name = "[Chat API]")
//public class LoadChatController {
//
//    private final LoadChatService loadChatService;
//
//    @GetMapping("/{chatRoomId}")
//    public JMResponse<List<Chat>> loadAllChat(@PathVariable Long chatRoomId){
//        List<Chat> result = loadChatService.findAllChat(chatRoomId);
//        return JMResponse.ok(result);
//    }
//}
