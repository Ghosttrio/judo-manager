//package com.judomanager.chat.domain.chat.repository.chatroom;
//
//import com.judomanager.chat.domain.chat.domain.ChatRoom;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//
//import java.util.List;
//
//import static com.judomanager.domain.chat.domain.QChatRoom.chatRoom;
//import static com.judomanager.domain.chat.domain.QChatRoomMember.chatRoomMember;
//
//@RequiredArgsConstructor
//public class ChatRoomQueryRepositoryImpl implements ChatRoomQueryRepository{
//
//    private final JPAQueryFactory query;
//
//    @Override
//    public List<ChatRoom> findAllByUserId(Long userId) {
//        List<Long> chatRoomIdList = query.select(chatRoomMember.chatRoomId).from(chatRoomMember)
//                .where(chatRoomMember.userId.eq(userId))
//                .fetch();
//
//        return query.selectFrom(chatRoom)
//                .where(chatRoom.id.in(chatRoomIdList))
//                .orderBy(chatRoom.createdAt.asc())
//                .fetch();
//    }
//}
