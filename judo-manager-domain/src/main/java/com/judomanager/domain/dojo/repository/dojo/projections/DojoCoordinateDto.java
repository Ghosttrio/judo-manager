package com.judomanager.domain.dojo.repository.dojo.projections;

public record DojoCoordinateDto(
        Double radius,
        Double latitude,
        Double longitude
) {
}
