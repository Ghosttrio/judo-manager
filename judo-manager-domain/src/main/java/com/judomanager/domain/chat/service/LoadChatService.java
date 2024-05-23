package com.judomanager.domain.chat.service;

import com.judomanager.domain.chat.domain.Chat;
import com.judomanager.domain.chat.repository.chat.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoadChatService {

    private final ChatRepository chatRepository;

    public List<Chat> findAllChat(Long chatRoomId){
        return chatRepository.findAllByChatRoomId(chatRoomId);
    }
}
