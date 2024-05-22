package com.judomanager.domain.dojo.repository;

import com.judomanager.domain.dojo.domain.Dojo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.judomanager.domain.dojo.domain.QDojo.dojo;


@RequiredArgsConstructor
public class DojoQueryRepositoryImpl implements DojoQueryRepository {

    private final JPAQueryFactory query;


    @Override
    public Optional<Dojo> findByDojoCode(String dojoCode){
        return Optional.ofNullable(query.selectFrom(dojo)
                .where(dojo.dojoCode.eq(dojoCode))
                .fetchOne());
    }

}
