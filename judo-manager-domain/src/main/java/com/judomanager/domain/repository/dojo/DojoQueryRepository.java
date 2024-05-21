package com.judomanager.domain.repository.dojo;



import com.judomanager.domain.domain.dojo.Dojo;

import java.util.Optional;

public interface DojoQueryRepository {
    Optional<Dojo> findByDojoCode(String dojoCode);
}
