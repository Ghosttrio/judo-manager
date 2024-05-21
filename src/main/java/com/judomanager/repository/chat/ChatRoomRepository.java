package com.judomanager.repository.chat;

import com.judomanager.domain.chat.Chat;
import com.judomanager.domain.chat.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
