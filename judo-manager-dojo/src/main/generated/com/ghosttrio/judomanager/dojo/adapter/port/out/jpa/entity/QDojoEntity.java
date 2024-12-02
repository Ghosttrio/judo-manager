package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDojoEntity is a Querydsl query type for DojoEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDojoEntity extends EntityPathBase<DojoEntity> {

    private static final long serialVersionUID = 1165150620L;

    public static final QDojoEntity dojoEntity = new QDojoEntity("dojoEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath dojoCode = createString("dojoCode");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final StringPath location = createString("location");

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final NumberPath<Long> masterId = createNumber("masterId", Long.class);

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final NumberPath<Double> radius = createNumber("radius", Double.class);

    public final EnumPath<DojoState> state = createEnum("state", DojoState.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QDojoEntity(String variable) {
        super(DojoEntity.class, forVariable(variable));
    }

    public QDojoEntity(Path<? extends DojoEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDojoEntity(PathMetadata metadata) {
        super(DojoEntity.class, metadata);
    }

}

