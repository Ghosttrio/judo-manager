package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.pass;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.PassEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.QPassEntity.passEntity;


@RequiredArgsConstructor
public class PassQueryRepositoryImpl implements PassQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public Optional<PassEntity> findByUserPass(Long userId) {
        return Optional.ofNullable(
                query.selectFrom(passEntity).where(passEntity.userId.eq(userId)).fetchOne()
        );
    }
}
