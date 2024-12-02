package com.judomanager.chat.adapter.port.in.request;

public record ChatDto(
	Long userId,
	Long chatRoomId,
	String content
) {
}
