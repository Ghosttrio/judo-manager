package com.ghosttrio.judomanager.board.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.ghosttrio.judomanager.board.adapter.port.out.entity.PostEntity;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPost extends EntityPathBase<PostEntity> {

    private static final long serialVersionUID = 640403811L;

    public static final QPost post = new QPost("post");

    public final NumberPath<Long> boardId = createNumber("boardId", Long.class);

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public QPost(String variable) {
        super(PostEntity.class, forVariable(variable));
    }

    public QPost(Path<? extends PostEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPost(PathMetadata metadata) {
        super(PostEntity.class, metadata);
    }

}

