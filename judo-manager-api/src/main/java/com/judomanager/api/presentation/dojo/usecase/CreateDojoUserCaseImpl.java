package com.judomanager.api.presentation.dojo.usecase;

import com.judomanager.api.presentation.dojo.mapper.DojoMapper;
import com.judomanager.domain.dojo.adaptor.DojoAdaptor;
import com.judomanager.domain.dojo.domain.Dojo;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class CreateDojoUserCaseImpl implements CreateDojoUseCase {

    private final DojoAdaptor dojoAdaptor;
    private final DojoMapper dojoMapper;

    @Override
    public void execute(Long masterId, String name, String location, String phone, Double latitude, Double longitude, Double radius) {
        String dojoCode = generateDojoCode();
        Dojo dojo = dojoMapper.toEntity(masterId, name, location, phone, dojoCode, latitude, longitude, radius);
        dojoAdaptor.create(dojo);
    }

    private String generateDojoCode(){
        return UUID.randomUUID().toString();
    }
}
