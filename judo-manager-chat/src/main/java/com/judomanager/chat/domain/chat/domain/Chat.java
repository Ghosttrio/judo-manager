package com.judomanager.chat.domain.chat.domain;

import com.judomanager.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name = "tb_chat")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long id;

    private Long userId;
    private Long chatRoomId;

    private String content;

    public static Chat create(Long userId, Long chatRoomId, String content){
        return new Chat(null, userId, chatRoomId, content);
    }

}
