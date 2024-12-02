package com.judomanager.chat.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QChatRoomMember is a Querydsl query type for ChatRoomMember
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChatRoomMember extends EntityPathBase<ChatRoomMember> {

    private static final long serialVersionUID = -562943291L;

    public static final QChatRoomMember chatRoomMember = new QChatRoomMember("chatRoomMember");

    public final NumberPath<Long> chatRoomId = createNumber("chatRoomId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QChatRoomMember(String variable) {
        super(ChatRoomMember.class, forVariable(variable));
    }

    public QChatRoomMember(Path<? extends ChatRoomMember> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChatRoomMember(PathMetadata metadata) {
        super(ChatRoomMember.class, metadata);
    }

}

