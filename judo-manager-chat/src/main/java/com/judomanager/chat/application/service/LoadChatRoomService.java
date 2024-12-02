package com.judomanager.chat.application.service;

import static com.judomanager.chat.common.exception.ErrorCode.*;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.judomanager.chat.adapter.port.out.chatroom.ChatRoomRepository;
import com.judomanager.chat.common.exception.JMException;
import com.judomanager.chat.domain.ChatRoom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class LoadChatRoomService {

	private final ChatRoomRepository chatRoomRepository;

	public ChatRoom findById(Long chatRoomId) {
		return chatRoomRepository.findById(chatRoomId)
			.orElseThrow(() -> new JMException(CHAT_ROOM_NOT_FOUND));
	}

	public List<ChatRoom> findAllByUserId(Long userId) {
		return chatRoomRepository.findAllByUserId(userId);
	}
}
