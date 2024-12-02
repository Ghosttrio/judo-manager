package com.judomanager.chat.adapter.port.out.chatroom;

import static com.judomanager.chat.domain.QChatRoom.*;
import static com.judomanager.chat.domain.QChatRoomMember.*;

import java.util.List;

import com.judomanager.chat.domain.ChatRoom;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChatRoomQueryRepositoryImpl implements ChatRoomQueryRepository {

	private final JPAQueryFactory query;

	@Override
	public List<ChatRoom> findAllByUserId(Long userId) {
		List<Long> chatRoomIdList = query.select(chatRoomMember.chatRoomId).from(chatRoomMember)
			.where(chatRoomMember.userId.eq(userId))
			.fetch();

		return query.selectFrom(chatRoom)
			.where(chatRoom.id.in(chatRoomIdList))
			.orderBy(chatRoom.createdAt.asc())
			.fetch();
	}
}
