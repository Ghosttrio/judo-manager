package com.judomanager.domain.chat.repository.chatroom;


import com.judomanager.domain.chat.domain.ChatRoom;

import java.util.List;

public interface ChatRoomQueryRepository {
    List<ChatRoom> findAllByUserId(Long userId);
}
