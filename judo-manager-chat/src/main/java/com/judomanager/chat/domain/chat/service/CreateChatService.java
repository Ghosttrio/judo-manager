//package com.judomanager.chat.domain.chat.service;
//
//import com.judomanager.chat.domain.chat.domain.Chat;
//import com.judomanager.chat.domain.chat.repository.chat.ChatRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class CreateChatService {
//
//    private final ChatRepository chatRepository;
//    private final LoadChatRoomService loadChatRoomService;
//
//    @Transactional
//    public void create(Long userId, Long chatRoomId, String content){
//        validateChatRoomExist(chatRoomId);
//        Chat chat = Chat.create(userId, chatRoomId, content);
//        chatRepository.save(chat);
//    }
//
//    private void validateChatRoomExist(Long chatRoomId){
//        loadChatRoomService.findById(chatRoomId);
//    }
//}
