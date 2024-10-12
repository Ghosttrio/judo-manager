package com.ghosttrio.judomanager.dojo.dojo.service;

import com.judomanager.common.exception.JMException;
import com.ghosttrio.judomanager.dojo.dojo.domain.Dojo;
import com.ghosttrio.judomanager.dojo.dojo.domain.DojoState;
import com.ghosttrio.judomanager.dojo.dojo.repository.dojo.DojoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.judomanager.common.exception.ErrorCode.DOJO_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UpdateDojoService {

    private final DojoRepository dojoRepository;

    @Transactional
    public void updateState(Long dojoId, DojoState state){
        Dojo dojo = dojoRepository.findById(dojoId).orElseThrow(() -> new JMException(ErrorCode.DOJO_NOT_FOUND));
        dojo.updateState(state);
    }
}
