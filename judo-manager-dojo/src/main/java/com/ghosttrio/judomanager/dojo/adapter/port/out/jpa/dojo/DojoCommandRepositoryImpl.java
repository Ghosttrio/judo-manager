package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.dojo;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.DojoState;
import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.QDojoEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.QDojoEntity.dojoEntity;

@RequiredArgsConstructor
public class DojoCommandRepositoryImpl implements DojoCommandRepository {

    private final JPAQueryFactory query;

    @Override
    public void update(Long dojoId, DojoState state) {
        query.update(dojoEntity)
                .set(dojoEntity.state, state)
                .where(dojoEntity.id.eq(dojoId))
                .execute();
    }
}
