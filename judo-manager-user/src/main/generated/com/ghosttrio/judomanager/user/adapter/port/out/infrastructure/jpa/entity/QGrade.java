package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.ghosttrio.judomanager.user.domain.Grade;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGrade is a Querydsl query type for Grade
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QGrade extends EnumPath<Grade> {

    private static final long serialVersionUID = 1867364416L;

    public static final QGrade grade = new QGrade("grade");

    public QGrade(String variable) {
        super(Grade.class, forVariable(variable));
    }

    public QGrade(Path<Grade> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGrade(PathMetadata metadata) {
        super(Grade.class, metadata);
    }

}

