package com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAttendanceEntity is a Querydsl query type for AttendanceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAttendanceEntity extends EntityPathBase<AttendanceEntity> {

    private static final long serialVersionUID = -1293217796L;

    public static final QAttendanceEntity attendanceEntity = new QAttendanceEntity("attendanceEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final EnumPath<Approval> approval = createEnum("approval", Approval.class);

    public final DateTimePath<java.time.LocalDateTime> attendanceTime = createDateTime("attendanceTime", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> dojoId = createNumber("dojoId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QAttendanceEntity(String variable) {
        super(AttendanceEntity.class, forVariable(variable));
    }

    public QAttendanceEntity(Path<? extends AttendanceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAttendanceEntity(PathMetadata metadata) {
        super(AttendanceEntity.class, metadata);
    }

}

