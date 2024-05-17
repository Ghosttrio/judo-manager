package com.judomanager.service.dojo;

import com.judomanager.common.exception.JMException;
import com.judomanager.repository.dojo.DojoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.judomanager.common.exception.ErrorCode.DOJO_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadDojoService {

    private final DojoRepository dojoRepository;

    public void checkDojoExist(Long dojoId){
        dojoRepository.findById(dojoId).orElseThrow(() -> new JMException(DOJO_NOT_FOUND));
    }
}
