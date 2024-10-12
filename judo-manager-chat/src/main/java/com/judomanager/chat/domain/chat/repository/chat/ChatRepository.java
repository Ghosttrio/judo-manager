package com.judomanager.chat.domain.chat.repository.chat;

import com.judomanager.chat.domain.chat.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long>, ChatQueryRepository {
}
