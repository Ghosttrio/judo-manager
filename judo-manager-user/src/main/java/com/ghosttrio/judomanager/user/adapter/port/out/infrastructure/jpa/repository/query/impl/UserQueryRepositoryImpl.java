package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.repository.query.impl;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserEntity;
import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.repository.query.UserQueryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.QUserEntity.userEntity;


@RequiredArgsConstructor
public class UserQueryRepositoryImpl implements UserQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public List<UserEntity> findAllUserByDojoId(Long dojoId) {
        return query.selectFrom(userEntity).where(userEntity.dojoId.eq(dojoId)).fetch();
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return Optional.ofNullable(query.selectFrom(userEntity).where(userEntity.email.eq(email)).fetchOne());
    }

    @Override
    public Optional<UserEntity> findByNickname(String nickname) {
        return Optional.ofNullable(query.selectFrom(userEntity).where(userEntity.nickname.eq(nickname)).fetchOne());
    }
}
