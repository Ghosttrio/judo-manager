package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.dojo;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.dojo.projections.DojoCoordinateDto;
import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.DojoEntity;

import java.util.Optional;

public interface DojoQueryRepository {
    Optional<DojoEntity> findByDojoCode(String dojoCode);

    DojoCoordinateDto findDojoCoordinate(Long dojoId);

    Optional<DojoEntity> findByUserId(Long userId);
}
