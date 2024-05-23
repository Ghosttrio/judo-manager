package com.judomanager.api.presentation.chat;

import com.judomanager.api.presentation.chat.request.CreateChatRoomRequest;
import com.judomanager.common.exception.JMResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat/room")
public class CreateChatRoomController {

    @PostMapping
    public JMResponse<Void> createChatRoom(@RequestBody CreateChatRoomRequest request){
        return JMResponse.ok();
    }
}
