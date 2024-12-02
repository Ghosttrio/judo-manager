package com.ghosttrio.judomanager.dojo.application.port.in.impl;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.DojoState;
import com.ghosttrio.judomanager.dojo.application.port.in.UpdateDojoStatusUseCase;
import com.ghosttrio.judomanager.dojo.application.service.UpdateDojoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateDojoStatusUseCaseImpl implements UpdateDojoStatusUseCase {

    private final UpdateDojoService updateDojoService;

    @Override
    public void execute(Long dojoId, DojoState state) {
        updateDojoService.updateState(dojoId, state);
    }
}
