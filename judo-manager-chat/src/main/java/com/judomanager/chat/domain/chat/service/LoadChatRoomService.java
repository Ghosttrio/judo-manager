package com.judomanager.chat.domain.chat.service;

import com.judomanager.common.exception.JMException;
import com.judomanager.chat.domain.chat.domain.ChatRoom;
import com.judomanager.chat.domain.chat.repository.chatroom.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.judomanager.common.exception.ErrorCode.CHAT_ROOM_NOT_FOUND;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class LoadChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoom findById(Long chatRoomId){
        return chatRoomRepository.findById(chatRoomId)
                .orElseThrow(() -> new JMException(CHAT_ROOM_NOT_FOUND));
    }

    public List<ChatRoom> findAllByUserId(Long userId){
        return chatRoomRepository.findAllByUserId(userId);
    }
}
