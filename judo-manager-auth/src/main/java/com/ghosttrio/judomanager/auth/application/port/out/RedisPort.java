package com.ghosttrio.judomanager.auth.application.port.out;


public interface RedisPort {
    String getValues(String key);

    void deleteValues(String key);

    void setValuesWithTimeout(String key, String value, long timeout);
}
