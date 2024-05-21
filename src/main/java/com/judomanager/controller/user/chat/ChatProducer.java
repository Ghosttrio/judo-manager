package com.judomanager.controller.user.chat;


import com.judomanager.dto.chat.ChatDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat")
public class ChatProducer {

    private final KafkaTemplate<String, ChatDto> kafkaTemplate;

    @PostMapping("/send")
    public void sendChat(@RequestBody ChatDto request){
        kafkaTemplate.send("", request);
    }

}
