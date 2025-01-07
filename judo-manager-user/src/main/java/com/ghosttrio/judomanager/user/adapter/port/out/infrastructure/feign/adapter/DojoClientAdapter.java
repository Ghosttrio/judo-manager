package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.feign.adapter;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.feign.client.DojoClient;
import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.feign.model.Dojo;
import com.ghosttrio.judomanager.user.domain.Grade;
import com.ghosttrio.judomanager.user.application.port.out.UserClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DojoClientAdapter implements UserClientPort {

    private final DojoClient dojoClient;

    @Override
    public Dojo findDojoByDojoCode(String dojoCode) {
        return dojoClient.findDojoByDojoCode(dojoCode);
    }

    @Override
    public Grade findUserGrade(Long userId) {
        return null;
    }
}
