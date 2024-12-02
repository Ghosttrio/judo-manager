package com.ghosttrio.judomanager.attendance.adapter.port.out.feign.response;

import lombok.Data;

@Data
public class DojoCoordinateDto {
    private Double latitude;
    private Double longitude;
    private Double radius;
}
