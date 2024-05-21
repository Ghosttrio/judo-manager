package com.judomanager.api.dto.dojo;

public record CreateDojoRequest(
        Long masterId,
        String name,
        String location,
        String phone
) {
}
