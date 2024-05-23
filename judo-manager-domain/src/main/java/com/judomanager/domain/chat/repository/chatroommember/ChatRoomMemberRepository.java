package com.judomanager.domain.chat.repository.chatroommember;

import com.judomanager.domain.chat.domain.ChatRoom;
import com.judomanager.domain.chat.domain.ChatRoomMember;
import com.judomanager.domain.chat.repository.chatroom.ChatRoomQueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomMemberRepository extends JpaRepository<ChatRoomMember, Long>, ChatRoomMemberQueryRepository {
}
