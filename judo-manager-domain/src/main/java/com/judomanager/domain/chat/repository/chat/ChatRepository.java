package com.judomanager.domain.chat.repository.chat;

import com.judomanager.domain.chat.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long>, ChatQueryRepository {
}
