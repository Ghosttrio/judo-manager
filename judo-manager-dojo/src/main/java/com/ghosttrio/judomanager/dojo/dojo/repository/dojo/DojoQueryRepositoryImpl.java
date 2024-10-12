package com.ghosttrio.judomanager.dojo.dojo.repository.dojo;

import com.ghosttrio.judomanager.dojo.dojo.domain.Dojo;
import com.ghosttrio.judomanager.dojo.dojo.repository.dojo.projections.DojoCoordinateDto;
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
        return Optional.ofNullable(query.selectFrom(QDojo.dojo)
                .where(QDojo.dojo.dojoCode.eq(dojoCode))
                .fetchOne());
    }

    @Override
    public DojoCoordinateDto findDojoCoordinate(Long dojoId){
        return query.select(
                Projections.bean(
                        DojoCoordinateDto.class,
                        QDojo.dojo.radius,
                        QDojo.dojo.latitude,
                        QDojo.dojo.longitude
                ))
                .from(QDojo.dojo)
                .where(QDojo.dojo.id.eq(dojoId))
                .fetchOne();
    }

    @Override
    public Optional<Dojo> findByUserId(Long userId) {

        Dojo result = query.select(QDojo.dojo)
                .from(QUser.user)
                .join(QDojo.dojo).on(QDojo.dojo.id.eq(QUser.user.dojoId))
                .where(QUser.user.id.eq(userId))
                .fetchOne();

        return Optional.ofNullable(result);
    }

}
