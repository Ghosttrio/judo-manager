package com.judomanager.repository.dojo;


import com.judomanager.domain.dojo.Dojo;

import java.util.Optional;

public interface DojoQueryRepository {
    Optional<Dojo> findByDojoCode(String dojoCode);
}
