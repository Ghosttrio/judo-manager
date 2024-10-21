package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.ghosttrio.judomanager.user.application.domain.QUser.user;


@RequiredArgsConstructor
public class UserQueryRepositoryImpl implements UserQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public List<UserEntity> findAllUserByDojoId(Long dojoId) {
        return query.selectFrom(user).where(user.dojoId.eq(dojoId)).fetch();
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return Optional.ofNullable(query.selectFrom(user).where(user.email.eq(email)).fetchOne());
    }
}
