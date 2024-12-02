package com.ghosttrio.judomanager.admin.application.port.in.dojo.impl;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.DojoState;
import com.ghosttrio.judomanager.admin.application.port.in.dojo.UpdateDojoUseCase;
import com.ghosttrio.judomanager.admin.application.service.UpdateDojoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateDojoUseCaseImpl implements UpdateDojoUseCase {

    private final UpdateDojoService updateDojoService;

    @Override
    public void execute(Long dojoId, DojoState state) {
        updateDojoService.update(dojoId, state);
    }
}
