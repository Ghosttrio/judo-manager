package com.judomanager.domain.dojo.service;

import com.judomanager.common.exception.JMException;
import com.judomanager.domain.dojo.domain.Dojo;
import com.judomanager.domain.dojo.domain.DojoState;
import com.judomanager.domain.dojo.repository.dojo.DojoRepository;
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
        Dojo dojo = dojoRepository.findById(dojoId).orElseThrow(() -> new JMException(DOJO_NOT_FOUND));
        dojo.updateState(state);
    }
}
