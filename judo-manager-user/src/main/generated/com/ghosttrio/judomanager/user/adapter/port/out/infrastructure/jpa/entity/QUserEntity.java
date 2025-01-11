package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserEntity is a Querydsl query type for UserEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserEntity extends EntityPathBase<UserEntity> {

    private static final long serialVersionUID = -976660283L;

    public static final QUserEntity userEntity = new QUserEntity("userEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final EnumPath<com.ghosttrio.judomanager.user.domain.Belt> belt = createEnum("belt", com.ghosttrio.judomanager.user.domain.Belt.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> dojoId = createNumber("dojoId", Long.class);

    public final StringPath email = createString("email");

    public final EnumPath<com.ghosttrio.judomanager.user.domain.Grade> grade = createEnum("grade", com.ghosttrio.judomanager.user.domain.Grade.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> lastLoginDate = createDateTime("lastLoginDate", java.time.LocalDateTime.class);

    public final StringPath nickname = createString("nickname");

    public final EnumPath<UserRole> role = createEnum("role", UserRole.class);

    public final EnumPath<UserState> state = createEnum("state", UserState.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QUserEntity(String variable) {
        super(UserEntity.class, forVariable(variable));
    }

    public QUserEntity(Path<? extends UserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserEntity(PathMetadata metadata) {
        super(UserEntity.class, metadata);
    }

}

