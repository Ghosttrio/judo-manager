package com.judomanager.chat.domain.chat.repository.chatroommember;

import com.judomanager.chat.domain.chat.domain.ChatRoomMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomMemberRepository extends JpaRepository<ChatRoomMember, Long>, ChatRoomMemberQueryRepository {
}
