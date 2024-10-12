package com.judomanager.chat.domain.chat.repository.chat;


import com.judomanager.chat.domain.chat.domain.Chat;

import java.util.List;

public interface ChatQueryRepository {

    List<Chat> findAllByChatRoomId(Long chatRoomId);
}
