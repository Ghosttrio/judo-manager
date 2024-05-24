package com.judomanager.domain.dojo.repository.dojo;

import com.judomanager.domain.dojo.domain.Dojo;
import com.judomanager.domain.dojo.repository.dojo.projections.DojoCoordinateDto;
import com.judomanager.domain.user.domain.QUser;
import com.judomanager.domain.user.domain.User;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.judomanager.domain.dojo.domain.QDojo.dojo;
import static com.judomanager.domain.user.domain.QUser.user;


@RequiredArgsConstructor
public class DojoQueryRepositoryImpl implements DojoQueryRepository {

    private final JPAQueryFactory query;


    @Override
    public Optional<Dojo> findByDojoCode(String dojoCode){
        return Optional.ofNullable(query.selectFrom(dojo)
                .where(dojo.dojoCode.eq(dojoCode))
                .fetchOne());
    }

    @Override
    public DojoCoordinateDto findDojoCoordinate(Long dojoId){
        return query.select(
                Projections.bean(
                        DojoCoordinateDto.class,
                        dojo.radius,
                        dojo.latitude,
                        dojo.longitude
                ))
                .from(dojo)
                .where(dojo.id.eq(dojoId))
                .fetchOne();
    }

    @Override
    public Optional<Dojo> findByUserId(Long userId) {

        Dojo result = query.select(dojo)
                .from(user)
                .join(dojo).on(dojo.id.eq(user.dojoId))
                .where(user.id.eq(userId))
                .fetchOne();

        return Optional.ofNullable(result);
    }

}
