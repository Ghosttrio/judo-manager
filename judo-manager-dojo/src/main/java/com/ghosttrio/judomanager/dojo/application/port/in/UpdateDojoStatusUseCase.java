package com.ghosttrio.judomanager.dojo.application.port.in;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.DojoState;

public interface UpdateDojoStatusUseCase {
    void execute(Long dojoId, DojoState state);
}
