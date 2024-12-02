package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.feign;

import com.ghosttrio.judomanager.user.application.port.out.UserClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DojoClientAdapter implements UserClientPort {

    private final DojoClient dojoClient;

    @Override
    public Dojo findDojoByDojoCode(String dojoCode) {
        return dojoClient.findDojoByDojoCode(dojoCode);
    }
}
