package com.judomanager.api.presentation.dojo.mapper;

import com.judomanager.domain.dojo.domain.Dojo;
import org.springframework.stereotype.Component;

@Component
public class DojoMapper {

    public Dojo toEntity(Long masterId, String name, String location, String phone, String dojoCode, Double latitude, Double longitude, Double radius) {
        return Dojo.create(masterId, name, location, phone, dojoCode, latitude, longitude, radius);
    }
}
