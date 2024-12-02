package com.judomanager.chat.adapter.port.out.chat;

import org.springframework.data.jpa.repository.JpaRepository;

import com.judomanager.chat.domain.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long>, ChatQueryRepository {
}
