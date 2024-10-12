package com.ghosttrio.judomanager.dojo.dojo.repository.dojo;




import com.ghosttrio.judomanager.dojo.dojo.domain.Dojo;
import com.ghosttrio.judomanager.dojo.dojo.repository.dojo.projections.DojoCoordinateDto;

import java.util.Optional;

public interface DojoQueryRepository {
    Optional<Dojo> findByDojoCode(String dojoCode);

    DojoCoordinateDto findDojoCoordinate(Long dojoId);

    Optional<Dojo> findByUserId(Long userId);
}
