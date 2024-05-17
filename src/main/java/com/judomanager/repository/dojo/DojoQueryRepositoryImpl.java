package com.judomanager.repository.dojo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class DojoQueryRepositoryImpl implements DojoQueryRepository {

    private final JPAQueryFactory query;

}
