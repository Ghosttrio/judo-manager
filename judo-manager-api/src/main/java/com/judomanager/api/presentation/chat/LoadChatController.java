package com.judomanager.api.presentation.chat;

import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.chat.domain.Chat;
import com.judomanager.domain.chat.service.LoadChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat")
public class LoadChatController {

    private final LoadChatService loadChatService;

    @GetMapping("/{chatRoomId}")
    public JMResponse<List<Chat>> loadAllChat(@PathVariable Long chatRoomId){
        List<Chat> result = loadChatService.findAllChat(chatRoomId);
        return JMResponse.ok(result);
    }
}
