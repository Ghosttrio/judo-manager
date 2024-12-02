package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPassEntity is a Querydsl query type for PassEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPassEntity extends EntityPathBase<PassEntity> {

    private static final long serialVersionUID = 396985821L;

    public static final QPassEntity passEntity = new QPassEntity("passEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DateTimePath<java.time.LocalDateTime> expireTime = createDateTime("expireTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> lessonId = createNumber("lessonId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QPassEntity(String variable) {
        super(PassEntity.class, forVariable(variable));
    }

    public QPassEntity(Path<? extends PassEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPassEntity(PathMetadata metadata) {
        super(PassEntity.class, metadata);
    }

}

