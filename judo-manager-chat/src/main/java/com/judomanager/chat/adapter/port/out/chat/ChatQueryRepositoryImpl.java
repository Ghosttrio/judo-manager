package com.judomanager.chat.adapter.port.out.chat;

import static com.judomanager.chat.domain.QChat.*;

import java.util.List;

import com.judomanager.chat.domain.Chat;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChatQueryRepositoryImpl implements ChatQueryRepository {

	private final JPAQueryFactory query;

	@Override
	public List<Chat> findAllByChatRoomId(Long chatRoomId) {
		return query.selectFrom(chat)
			.where(chat.chatRoomId.eq(chatRoomId))
			.orderBy(chat.createdAt.asc())
			.fetch();
	}
}
