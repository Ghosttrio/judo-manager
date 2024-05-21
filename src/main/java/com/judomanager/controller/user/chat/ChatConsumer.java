package com.judomanager.controller.user.chat;

import com.judomanager.dto.chat.ChatDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;


@Slf4j
@RequiredArgsConstructor
public class ChatConsumer {

    private final SimpMessageSendingOperations sendingOperations;

    @KafkaListener(topics = "", groupId = "")
    public void consume(ChatDto request) {
        sendingOperations.convertAndSend("/sub/", "");
    }

}
