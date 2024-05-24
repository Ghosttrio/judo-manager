package com.judomanager.domain.chat.repository.chat;

import com.judomanager.domain.chat.domain.Chat;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.judomanager.domain.chat.domain.QChat.chat;

@RequiredArgsConstructor
public class ChatQueryRepositoryImpl implements ChatQueryRepository{

    private final JPAQueryFactory query;

    @Override
    public List<Chat> findAllByChatRoomId(Long chatRoomId) {
        return query.selectFrom(chat)
                .where(chat.chatRoomId.eq(chatRoomId))
                .orderBy(chat.createdAt.asc())
                .fetch();
    }
}
