package com.ghosttrio.judomanager.dojo.application.service;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.pass.PassRepository;
import com.ghosttrio.judomanager.dojo.application.port.out.PassJpaPort;
import com.ghosttrio.judomanager.dojo.common.exception.ErrorCode;
import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.PassEntity;
import com.ghosttrio.judomanager.dojo.common.exception.JMException;
import com.ghosttrio.judomanager.dojo.domain.Pass;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadPassService {

    private final PassJpaPort passJpaPort;

    public Pass loadLessonByUserId(Long userId){
        return passJpaPort.findByUserPass(userId)
                .orElseThrow(() -> new JMException(ErrorCode.PASS_NOT_FOUND));
    }


}
