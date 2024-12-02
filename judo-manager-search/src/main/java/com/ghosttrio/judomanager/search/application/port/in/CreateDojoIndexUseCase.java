package com.ghosttrio.judomanager.search.application.port.in;

public interface CreateDojoIndexUseCase {
    void execute(Long dojoId, String name, String dojoCode, String price,
                 String location, Double latitude, Double longitude);
}
