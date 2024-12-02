package com.judomanager.chat.config.websocket;

import java.util.Objects;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class StompHandler implements ChannelInterceptor {

	@Override
	public void postSend(
		@NonNull Message message,
		@NonNull MessageChannel channel,
		boolean sent) {
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
		String sessionId = accessor.getSessionId();
		StompCommand command = accessor.getCommand();

		switch (Objects.requireNonNull(command)) {
			case CONNECT -> log.info("세션 들어옴 => {}", sessionId);
			case DISCONNECT -> log.info("세션 끊음 => {}", sessionId);
			default -> {
			}
		}

	}
}
