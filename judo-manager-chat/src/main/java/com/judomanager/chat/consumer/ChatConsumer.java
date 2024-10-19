//package com.judomanager.chat.consumer;
//
//import com.judomanager.common.util.ChatDto;
//import com.judomanager.chat.domain.chat.service.CreateChatService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.simp.SimpMessageSendingOperations;
//
//@Slf4j
//@RequiredArgsConstructor
//public class ChatConsumer {
//
//    private final SimpMessageSendingOperations sendingOperations;
//    private final CreateChatService createChatService;
//
//    @KafkaListener(topics = "", groupId = "")
//    public void consumeChat(ChatDto request) {
//
//        sendingOperations.convertAndSend("/sub/", "");
//
//        createChatService.create(request.userId(), request.chatRoomId(), request.content());
//    }
//
//}
