package com.ghosttrio.judomanager.dojo.application.port.in;

public interface CreateDojoUseCase {
    void execute(Long masterId, String name, String location, String phone, Double latitude, Double longitude, Double radius);
}
