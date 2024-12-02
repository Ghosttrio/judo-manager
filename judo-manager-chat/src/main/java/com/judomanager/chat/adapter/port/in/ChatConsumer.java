package com.judomanager.chat.adapter.port.in;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

import com.judomanager.chat.adapter.port.in.request.ChatDto;
import com.judomanager.chat.application.service.CreateChatService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChatConsumer {

	private final SimpMessageSendingOperations sendingOperations;
	private final CreateChatService createChatService;

	@KafkaListener(topics = "chat-topic", groupId = "chat-group")
	public void consumeChat(ChatDto request) {
		sendingOperations.convertAndSend("/sub/", "");
		createChatService.create(request.userId(), request.chatRoomId(), request.content());
	}
}
