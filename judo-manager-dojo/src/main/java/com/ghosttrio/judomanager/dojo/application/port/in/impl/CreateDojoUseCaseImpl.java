package com.ghosttrio.judomanager.dojo.application.port.in.impl;

import com.ghosttrio.judomanager.dojo.application.port.in.CreateDojoUseCase;
import com.ghosttrio.judomanager.dojo.application.service.CreateDojoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateDojoUseCaseImpl implements CreateDojoUseCase {

    private final CreateDojoService createDojoService;

    @Override
    public void execute(Long masterId, String name, String location, String phone, Double latitude, Double longitude, Double radius) {
        createDojoService.createDojo(masterId, name, location, phone, latitude, longitude, radius);
    }
}
