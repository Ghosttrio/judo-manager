package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.lesson;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.LessonEntity;
import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.QLessonEntity;
import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.QPassEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.QLessonEntity.lessonEntity;
import static com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.QPassEntity.passEntity;


@RequiredArgsConstructor
public class LessonQueryRepositoryImpl implements LessonQueryRepository {

    private final JPAQueryFactory query;


    @Override
    public Optional<LessonEntity> findByUserId(Long userId) {
        return Optional.ofNullable(
                query.selectFrom(lessonEntity)
                        .innerJoin(passEntity).on(passEntity.lessonId.eq(lessonEntity.id))
                        .where(passEntity.userId.eq(userId))
                        .fetchOne());
    }
}
