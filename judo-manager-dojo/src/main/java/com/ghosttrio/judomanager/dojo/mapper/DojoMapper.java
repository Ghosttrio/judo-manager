package com.ghosttrio.judomanager.dojo.mapper;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.DojoEntity;
import com.ghosttrio.judomanager.dojo.domain.Dojo;
import org.springframework.stereotype.Component;

@Component
public class DojoMapper {

    public DojoEntity toEntity(Dojo dojo) {
        return DojoEntity.create(
                dojo.getMasterId(),
                dojo.getName(),
                dojo.getLocation(),
                dojo.getPhone(),
                dojo.getDojoCode(),
                dojo.getLatitude(),
                dojo.getLongitude(),
                dojo.getRadius()
        );
    }

    public Dojo toDomain(DojoEntity dojoEntity) {
        return Dojo.create(
                dojoEntity.getId(),
                dojoEntity.getMasterId(),
                dojoEntity.getName(),
                dojoEntity.getLocation(),
                dojoEntity.getPhone(),
                dojoEntity.getDojoCode(),
                dojoEntity.getLatitude(),
                dojoEntity.getLongitude(),
                dojoEntity.getRadius()
        );
    }
}
