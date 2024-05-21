package com.judomanager.domain.service.dojo;

import com.judomanager.common.common.exception.JMException;
import com.judomanager.domain.domain.dojo.Dojo;
import com.judomanager.domain.domain.dojo.DojoState;
import com.judomanager.domain.repository.dojo.DojoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.judomanager.common.common.exception.ErrorCode.DOJO_NOT_FOUND;

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
