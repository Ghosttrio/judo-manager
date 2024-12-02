package com.ghosttrio.judomanager.admin.application.port.in.dojo.impl;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.Dojo;
import com.ghosttrio.judomanager.admin.application.port.in.dojo.LoadDojoUseCase;
import com.ghosttrio.judomanager.admin.application.service.LoadDojoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LoadDojoUseCaseImpl implements LoadDojoUseCase {

    private final LoadDojoService loadDojoService;

    @Override
    public List<Dojo> execute() {
        return loadDojoService.findAll();
    }
}
