package com.ghosttrio.judomanager.board.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.ghosttrio.judomanager.board.adapter.port.out.entity.CommentEntity;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QComment is a Querydsl query type for Comment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComment extends EntityPathBase<CommentEntity> {

    private static final long serialVersionUID = 1366909628L;

    public static final QComment comment = new QComment("comment");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QComment(String variable) {
        super(CommentEntity.class, forVariable(variable));
    }

    public QComment(Path<? extends CommentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComment(PathMetadata metadata) {
        super(CommentEntity.class, metadata);
    }

}

