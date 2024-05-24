package com.judomanager.domain.dojo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDojo is a Querydsl query type for Dojo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDojo extends EntityPathBase<Dojo> {

    private static final long serialVersionUID = 749956386L;

    public static final QDojo dojo = new QDojo("dojo");

    public final com.judomanager.domain.common.QBaseEntity _super = new com.judomanager.domain.common.QBaseEntity(this);

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

    public QDojo(String variable) {
        super(Dojo.class, forVariable(variable));
    }

    public QDojo(Path<? extends Dojo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDojo(PathMetadata metadata) {
        super(Dojo.class, metadata);
    }

}

