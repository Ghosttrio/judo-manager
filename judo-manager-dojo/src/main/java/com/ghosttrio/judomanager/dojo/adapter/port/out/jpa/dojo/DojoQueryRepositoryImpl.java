package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.dojo;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.dojo.projections.DojoCoordinateDto;
import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.DojoEntity;
import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.QDojoEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.QDojoEntity.dojoEntity;


@RequiredArgsConstructor
public class DojoQueryRepositoryImpl implements DojoQueryRepository {

    private final JPAQueryFactory query;


    @Override
    public Optional<DojoEntity> findByDojoCode(String dojoCode){
        return Optional.ofNullable(query.selectFrom(dojoEntity)
                .where(dojoEntity.dojoCode.eq(dojoCode))
                .fetchOne());
    }

    @Override
    public DojoCoordinateDto findDojoCoordinate(Long dojoId){
        return query.select(
                Projections.bean(
                        DojoCoordinateDto.class,
                        dojoEntity.radius,
                        dojoEntity.latitude,
                        dojoEntity.longitude
                ))
                .from(dojoEntity)
                .where(dojoEntity.id.eq(dojoId))
                .fetchOne();
    }

    @Override
    public Optional<DojoEntity> findByUserId(Long userId) {

//        DojoEntity result = query.select(QDojoEntity.dojoEntity)
//                .from(QUser.user)
//                .join(QDojo.dojo).on(QDojo.dojo.id.eq(QUser.user.dojoId))
//                .where(QUser.user.id.eq(userId))
//                .fetchOne();
        DojoEntity result = null;

        return Optional.ofNullable(result);
    }

}
