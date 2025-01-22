package com.ghosttrio.judomanager.admin.adapter.port.in.model;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.DojoState;

public record UpdateDojoRequest(
        DojoState state
) {
}
