package com.ghosttrio.judomanager.auth.application.service;

import com.ghosttrio.judomanager.auth.application.port.out.RedisPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RedisService {

    private final RedisPort redisPort;

    public String getValues(String key) {
        return redisPort.getValues(key);
    }

    @Transactional
    public void deleteValues(String key) {
        redisPort.deleteValues(key);
    }

    @Transactional
    public void setValuesWithTimeout(String key, String value, long timeout) {
        redisPort.setValuesWithTimeout(key, value, timeout);
    }
}
