package com.ghosttrio.judomanager.admin.application.port.in.dojo;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.DojoState;

public interface UpdateDojoUseCase {
    void execute(Long dojoId, DojoState state);
}
