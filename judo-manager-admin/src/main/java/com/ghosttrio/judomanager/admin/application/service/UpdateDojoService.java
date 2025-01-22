package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.DojoState;
import com.ghosttrio.judomanager.admin.application.port.out.DojoClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateDojoService {

    private final DojoClientPort dojoClientPort;

    private void executeUpdate(Long dojoId, DojoState state) {
        dojoClientPort.update(dojoId, state);
    }

    @Transactional
    public void update(Long dojoId, DojoState state) {
        executeUpdate(dojoId, state);
    }

}
