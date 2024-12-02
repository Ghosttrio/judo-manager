package com.judomanager.chat.adapter.port.in;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.judomanager.chat.application.service.LoadChatRoomService;
import com.judomanager.chat.common.exception.JMResponse;
import com.judomanager.chat.domain.ChatRoom;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat/room")
@Tag(name = "[Chat API]")
public class LoadChatRoomController {

	private final LoadChatRoomService loadChatRoomService;

	@GetMapping
	public JMResponse<List<ChatRoom>> loadChatRoom(@RequestParam Long userId) {
		List<ChatRoom> result = loadChatRoomService.findAllByUserId(userId);
		return JMResponse.ok(result);
	}
}
