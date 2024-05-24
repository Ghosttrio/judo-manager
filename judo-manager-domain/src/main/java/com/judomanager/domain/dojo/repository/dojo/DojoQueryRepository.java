package com.judomanager.domain.dojo.repository.dojo;




import com.judomanager.domain.dojo.domain.Dojo;
import com.judomanager.domain.dojo.repository.dojo.projections.DojoCoordinateDto;

import java.util.Optional;

public interface DojoQueryRepository {
    Optional<Dojo> findByDojoCode(String dojoCode);

    DojoCoordinateDto findDojoCoordinate(Long dojoId);

    Optional<Dojo> findByUserId(Long userId);
}
