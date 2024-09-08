package com.judomanager.api.presentation.dojo.usecase;

import org.springframework.stereotype.Component;

@Component
public interface CreateDojoUseCase {
    void execute(Long masterId, String name, String location, String phone, Double latitude, Double longitude, Double radius);
}
