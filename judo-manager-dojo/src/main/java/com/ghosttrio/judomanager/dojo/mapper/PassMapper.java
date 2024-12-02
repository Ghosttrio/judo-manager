package com.ghosttrio.judomanager.dojo.mapper;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.PassEntity;
import com.ghosttrio.judomanager.dojo.domain.Pass;
import org.springframework.stereotype.Component;

@Component
public class PassMapper {
    public PassEntity toEntity(Pass pass) {
        return PassEntity.create(pass);
    }

    public Pass toDomain(PassEntity passEntity) {
        return Pass.create(passEntity);
    }
}
