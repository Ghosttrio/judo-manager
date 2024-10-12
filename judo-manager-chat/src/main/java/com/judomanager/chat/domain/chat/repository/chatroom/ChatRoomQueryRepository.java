package com.judomanager.chat.domain.chat.repository.chatroom;


import com.judomanager.chat.domain.chat.domain.ChatRoom;

import java.util.List;

public interface ChatRoomQueryRepository {
    List<ChatRoom> findAllByUserId(Long userId);
}
