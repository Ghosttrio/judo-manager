package com.judomanager.infrastructure.redis;

import com.judomanager.common.exception.ErrorCode;
import com.judomanager.common.exception.JMException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public String getValues(String key) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(key))
                .orElseThrow(() -> new JMException(ErrorCode.EXPIRED_REFRESH_TOKEN));
    }

    @Transactional
    @Override
    public void deleteValues(String key) {
        redisTemplate.delete(key);
    }

    @Transactional
    @Override
    public void setValuesWithTimeout(String key, String value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.MILLISECONDS);
    }
}