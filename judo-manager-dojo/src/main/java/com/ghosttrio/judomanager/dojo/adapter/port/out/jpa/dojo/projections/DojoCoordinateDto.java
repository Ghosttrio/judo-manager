package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.dojo.projections;

public record DojoCoordinateDto(
        Double radius,
        Double latitude,
        Double longitude
) {
}
