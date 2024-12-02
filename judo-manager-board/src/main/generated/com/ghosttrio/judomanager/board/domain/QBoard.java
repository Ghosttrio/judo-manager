package com.ghosttrio.judomanager.board.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.ghosttrio.judomanager.board.adapter.port.out.entity.BoardEntity;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<BoardEntity> {

    private static final long serialVersionUID = -1635264893L;

    public static final QBoard board = new QBoard("board");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QBoard(String variable) {
        super(BoardEntity.class, forVariable(variable));
    }

    public QBoard(Path<? extends BoardEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoard(PathMetadata metadata) {
        super(BoardEntity.class, metadata);
    }

}

