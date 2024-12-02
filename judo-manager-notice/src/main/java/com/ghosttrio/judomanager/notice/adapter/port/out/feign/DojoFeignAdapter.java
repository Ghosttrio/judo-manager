package com.ghosttrio.judomanager.notice.adapter.port.out.feign;

import com.ghosttrio.judomanager.notice.application.port.out.DojoFeignPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DojoFeignAdapter implements DojoFeignPort {

    private final DojoFeignClient dojoFeignClient;

    @Override
    public void checkDojoExist(Long dojoId) {

    }
}
