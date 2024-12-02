package com.ghosttrio.judomanager.dojo.application.port.out;

import com.ghosttrio.judomanager.dojo.domain.Pass;

import java.util.Optional;

public interface PassJpaPort {
    Optional<Pass> findByUserPass(Long userId);
}
