package com.ghosttrio.judomanager.auth.adapter.port.out.redis;

import com.ghosttrio.judomanager.auth.application.port.out.RedisPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisAdapter implements RedisPort {

    private final RedisRepository redisRepository;

    @Override
    public String getValues(String key) {
        return redisRepository.getValues(key);
    }

    @Override
    public void deleteValues(String key) {
        redisRepository.deleteValues(key);
    }

    @Override
    public void setValuesWithTimeout(String key, String value, long timeout) {
        redisRepository.setValuesWithTimeout(key, value, timeout);
    }
}
