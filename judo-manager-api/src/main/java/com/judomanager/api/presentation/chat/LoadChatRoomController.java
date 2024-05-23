package com.judomanager.api.presentation.chat;

import com.judomanager.api.security.UserId;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.chat.domain.ChatRoom;
import com.judomanager.domain.chat.service.LoadChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat/room")
public class LoadChatRoomController {

    private final LoadChatRoomService loadChatRoomService;

    @GetMapping
    public JMResponse<List<ChatRoom>> loadChatRoom(@UserId Long userId){
        List<ChatRoom> result = loadChatRoomService.findAllByUserId(userId);
        return JMResponse.ok(result);
    }
}
