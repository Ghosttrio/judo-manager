package com.judomanager.domain.dojo.repository;




import com.judomanager.domain.dojo.domain.Dojo;

import java.util.Optional;

public interface DojoQueryRepository {
    Optional<Dojo> findByDojoCode(String dojoCode);
}
