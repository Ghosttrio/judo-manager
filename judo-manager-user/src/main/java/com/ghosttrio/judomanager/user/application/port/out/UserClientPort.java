package com.ghosttrio.judomanager.user.application.port.out;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.feign.Dojo;

import java.util.Optional;

public interface UserClientPort {
    Optional<Dojo> findDojoByDojoCode(String dojoCode);
}
