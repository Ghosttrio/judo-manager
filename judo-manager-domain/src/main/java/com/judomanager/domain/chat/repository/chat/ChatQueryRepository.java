package com.judomanager.domain.chat.repository.chat;


import com.judomanager.domain.chat.domain.Chat;

import java.util.List;

public interface ChatQueryRepository {

    List<Chat> findAllByChatRoomId(Long chatRoomId);
}
