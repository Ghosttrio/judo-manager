package com.ghosttrio.judomanager.dojo.application.service;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.DojoState;
import com.ghosttrio.judomanager.dojo.application.port.out.DojoJpaPort;
import com.ghosttrio.judomanager.dojo.common.exception.ErrorCode;
import com.ghosttrio.judomanager.dojo.common.exception.JMException;
import com.ghosttrio.judomanager.dojo.domain.Dojo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UpdateDojoService {

    private final DojoJpaPort dojoJpaPort;

    @Transactional
    public void updateState(Long dojoId, DojoState state) {
        Dojo dojo = dojoJpaPort.findById(dojoId)
                .orElseThrow(() -> new JMException(ErrorCode.DOJO_NOT_FOUND));
        Dojo result = dojo.updateState(state);
        dojoJpaPort.save(result);
    }
}
