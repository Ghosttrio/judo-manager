package com.ghosttrio.judomanager.dojo.dojo.repository.pass;

import com.ghosttrio.judomanager.dojo.dojo.domain.Pass;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.judomanager.domain.dojo.domain.QPass.pass;

@RequiredArgsConstructor
public class PassQueryRepositoryImpl implements PassQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public Optional<Pass> findByUserPass(Long userId) {
        return Optional.ofNullable(
                query.selectFrom(pass).where(pass.userId.eq(userId)).fetchOne()
        );
    }
}
