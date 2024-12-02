package com.judomanager.chat.adapter.port.out.chatroom;

import org.springframework.data.jpa.repository.JpaRepository;

import com.judomanager.chat.domain.ChatRoom;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long>, ChatRoomQueryRepository {
}
