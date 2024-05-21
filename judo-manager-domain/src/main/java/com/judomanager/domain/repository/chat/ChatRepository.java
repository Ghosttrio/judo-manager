package com.judomanager.domain.repository.chat;

import com.judomanager.domain.domain.chat.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
