package com.ghosttrio.judomanager.user.application.port.out;

public interface UserRedisPort {
    String getValues(String key);

    void deleteValues(String key);

    void setValuesWithTimeout(String key, String value, long timeout);
}
