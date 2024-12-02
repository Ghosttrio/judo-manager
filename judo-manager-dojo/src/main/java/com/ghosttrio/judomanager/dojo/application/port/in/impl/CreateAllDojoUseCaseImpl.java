package com.ghosttrio.judomanager.dojo.application.port.in.impl;

import com.ghosttrio.judomanager.dojo.application.port.in.CreateAllDojoUseCase;
import com.ghosttrio.judomanager.dojo.application.service.CreateDojoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAllDojoUseCaseImpl implements CreateAllDojoUseCase {

    private final CreateDojoService createDojoService;

    @Override
    public void execute() {
        createDojoService.createAllDojo();
    }
}
