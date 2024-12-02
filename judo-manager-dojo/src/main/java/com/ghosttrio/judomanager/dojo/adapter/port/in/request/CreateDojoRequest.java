package com.ghosttrio.judomanager.dojo.adapter.port.in.request;

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
