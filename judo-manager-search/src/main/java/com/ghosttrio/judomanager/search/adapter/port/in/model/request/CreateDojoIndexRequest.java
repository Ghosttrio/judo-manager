package com.ghosttrio.judomanager.search.adapter.port.in.model.request;

public record CreateDojoIndexRequest(
        Long dojoId,
        String name,
        String dojoCode,
        String price,
        String location,
        Double latitude,
        Double longitude
) {
}
