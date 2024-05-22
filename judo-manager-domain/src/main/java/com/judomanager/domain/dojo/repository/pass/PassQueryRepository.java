package com.judomanager.domain.dojo.repository.pass;

import com.judomanager.domain.dojo.domain.Pass;

import java.util.Optional;

public interface PassQueryRepository {

    Optional<Pass> findByUserPass(Long userId);
}
