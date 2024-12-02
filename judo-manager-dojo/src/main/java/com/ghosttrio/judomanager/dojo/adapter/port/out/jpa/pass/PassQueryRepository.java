package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.pass;


import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.PassEntity;

import java.util.Optional;

public interface PassQueryRepository {

    Optional<PassEntity> findByUserPass(Long userId);
}
