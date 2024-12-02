package com.judomanager.chat.adapter.port.out.chatroommember;

import org.springframework.data.jpa.repository.JpaRepository;

import com.judomanager.chat.domain.ChatRoomMember;

public interface ChatRoomMemberRepository extends JpaRepository<ChatRoomMember, Long>, ChatRoomMemberQueryRepository {
}
