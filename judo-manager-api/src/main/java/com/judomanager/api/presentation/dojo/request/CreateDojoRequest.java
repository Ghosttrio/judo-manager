package com.judomanager.api.presentation.dojo.request;

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
