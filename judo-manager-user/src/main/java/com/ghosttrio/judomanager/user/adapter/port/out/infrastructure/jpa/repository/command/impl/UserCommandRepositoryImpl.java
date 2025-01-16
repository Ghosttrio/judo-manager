package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.repository.command.impl;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.repository.command.UserCommandRepository;
import com.ghosttrio.judomanager.user.domain.Belt;
import com.ghosttrio.judomanager.user.domain.Grade;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.QUserEntity.userEntity;

@Repository
@RequiredArgsConstructor
public class UserCommandRepositoryImpl implements UserCommandRepository {

    private final JPAQueryFactory query;

    @Override
    public void updateUserDan(Long userId, Grade grade, Belt belt) {
        query.update(userEntity)
                .set(userEntity.grade, grade)
                .set(userEntity.belt, belt)
                .where(userEntity.id.eq(userId))
                .execute();
    }
}
