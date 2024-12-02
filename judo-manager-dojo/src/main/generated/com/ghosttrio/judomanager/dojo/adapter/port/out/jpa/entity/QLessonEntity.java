package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLessonEntity is a Querydsl query type for LessonEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLessonEntity extends EntityPathBase<LessonEntity> {

    private static final long serialVersionUID = -1020291196L;

    public static final QLessonEntity lessonEntity = new QLessonEntity("lessonEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> dojoId = createNumber("dojoId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> endTime = createDateTime("endTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final DateTimePath<java.time.LocalDateTime> startTime = createDateTime("startTime", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QLessonEntity(String variable) {
        super(LessonEntity.class, forVariable(variable));
    }

    public QLessonEntity(Path<? extends LessonEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLessonEntity(PathMetadata metadata) {
        super(LessonEntity.class, metadata);
    }

}

