package com.judomanager.domain.domain.dojo;

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

    private static final long serialVersionUID = 98594698L;

    public static final QDojo dojo = new QDojo("dojo");

    public final com.judomanager.common.common.QBaseEntity _super = new com.judomanager.common.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath dojoCode = createString("dojoCode");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath location = createString("location");

    public final NumberPath<Long> masterId = createNumber("masterId", Long.class);

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

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

