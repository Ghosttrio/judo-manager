package com.judomanager.infrastructure.redis;


public interface RedisService {

    String getValues(String key);

    void deleteValues(String key);

    void setValuesWithTimeout(String key, String value, long timeout);

}
