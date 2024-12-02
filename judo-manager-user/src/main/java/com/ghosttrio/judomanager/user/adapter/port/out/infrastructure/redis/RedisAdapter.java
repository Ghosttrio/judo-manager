package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.redis;

import com.ghosttrio.judomanager.user.application.port.out.UserRedisPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisAdapter implements UserRedisPort {

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