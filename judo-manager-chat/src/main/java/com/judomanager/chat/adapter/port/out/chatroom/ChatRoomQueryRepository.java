package com.judomanager.chat.adapter.port.out.chatroom;

import java.util.List;

import com.judomanager.chat.domain.ChatRoom;

public interface ChatRoomQueryRepository {
	List<ChatRoom> findAllByUserId(Long userId);
}
