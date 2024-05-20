package com.judomanager.domain.chat;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long id;

    private Long userId;
    private Long chatRoomId;

}
