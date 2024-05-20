package com.judomanager.service.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    public Optional<String> getValues(String key) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(key));
    }

    @Transactional
    public void deleteValues(String key) {
        redisTemplate.delete(key);
    }

    @Transactional
    public void setValuesWithTimeout(String key, String value, long timeout) {
        System.out.println(key);
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.MILLISECONDS);
    }
}