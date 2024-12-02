package com.ghosttrio.judomanager.search.application.port.in.impl;

import com.ghosttrio.judomanager.search.application.port.in.CreateDojoIndexUseCase;
import com.ghosttrio.judomanager.search.application.service.CreateDojoIndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateDojoIndexUseCaseImpl implements CreateDojoIndexUseCase {

    private final CreateDojoIndexService createDojoIndexService;


    @Override
    public void execute(Long dojoId, String name, String dojoCode, String price,
                        String location, Double latitude, Double longitude) {
        createDojoIndexService.create(dojoId, name, dojoCode, price, location, latitude, longitude);
    }
}
