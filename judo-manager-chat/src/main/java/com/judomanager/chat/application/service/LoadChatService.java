package com.judomanager.chat.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.judomanager.chat.adapter.port.out.chat.ChatRepository;
import com.judomanager.chat.domain.Chat;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoadChatService {

	private final ChatRepository chatRepository;

	public List<Chat> findAllChat(Long chatRoomId) {
		return chatRepository.findAllByChatRoomId(chatRoomId);
	}
}
