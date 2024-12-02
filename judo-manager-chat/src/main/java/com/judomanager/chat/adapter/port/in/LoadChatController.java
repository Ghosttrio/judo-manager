package com.judomanager.chat.adapter.port.in;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.judomanager.chat.application.service.LoadChatService;
import com.judomanager.chat.common.exception.JMResponse;
import com.judomanager.chat.domain.Chat;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat")
@Tag(name = "[Chat API]")
public class LoadChatController {

	private final LoadChatService loadChatService;

	@GetMapping("/{chatRoomId}")
	public JMResponse<List<Chat>> loadAllChat(@PathVariable Long chatRoomId) {
		List<Chat> result = loadChatService.findAllChat(chatRoomId);
		return JMResponse.ok(result);
	}
}
