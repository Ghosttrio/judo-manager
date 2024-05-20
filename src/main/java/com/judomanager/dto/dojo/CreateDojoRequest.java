package com.judomanager.dto.dojo;

public record CreateDojoRequest(
        Long masterId,
        String name,
        String location,
        String phone
) {
}
