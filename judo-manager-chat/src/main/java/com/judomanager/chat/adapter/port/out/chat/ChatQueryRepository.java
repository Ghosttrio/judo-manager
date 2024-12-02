package com.judomanager.chat.adapter.port.out.chat;

import java.util.List;

import com.judomanager.chat.domain.Chat;

public interface ChatQueryRepository {

	List<Chat> findAllByChatRoomId(Long chatRoomId);
}
