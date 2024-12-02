package com.ghosttrio.judomanager.dojo.application.port.out;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.dojo.projections.DojoCoordinateDto;
import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.DojoState;
import com.ghosttrio.judomanager.dojo.domain.Dojo;

import java.util.List;
import java.util.Optional;

public interface DojoJpaPort {
    void save(Dojo dojo);

    Optional<Dojo> findById(Long dojoId);

    List<Dojo> findAll();

    Optional<Dojo> findByDojoCode(String dojoCode);

    Optional<Dojo> findByUserId(Long userId);

    DojoCoordinateDto findDojoCoordinate(Long dojoId);

    void update(Long dojoId, DojoState state);
}
