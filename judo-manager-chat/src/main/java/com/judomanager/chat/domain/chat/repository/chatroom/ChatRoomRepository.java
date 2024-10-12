package com.judomanager.chat.domain.chat.repository.chatroom;

import com.judomanager.chat.domain.chat.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long>, ChatRoomQueryRepository {
}
