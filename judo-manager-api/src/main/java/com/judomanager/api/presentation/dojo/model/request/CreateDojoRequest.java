package com.judomanager.api.presentation.dojo.model.request;

public record CreateDojoRequest(
        Long masterId,
        String name,
        String location,
        String phone,
        Double latitude,
        Double longitude,
        Double radius
) {
}
