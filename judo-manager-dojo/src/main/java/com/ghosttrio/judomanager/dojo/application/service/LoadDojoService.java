package com.ghosttrio.judomanager.dojo.application.service;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.dojo.DojoRepository;
import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.dojo.projections.DojoCoordinateDto;
import com.ghosttrio.judomanager.dojo.application.port.out.DojoJpaPort;
import com.ghosttrio.judomanager.dojo.common.exception.ErrorCode;
import com.ghosttrio.judomanager.dojo.common.exception.JMException;
import com.ghosttrio.judomanager.dojo.domain.Dojo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadDojoService {

    private final DojoJpaPort dojoJpaPort;

    public void checkDojoExist(Long dojoId){
        dojoJpaPort.findById(dojoId).orElseThrow(() -> new JMException(ErrorCode.DOJO_NOT_FOUND));
    }

    public List<Dojo> findAll(){
        return dojoJpaPort.findAll();
    }

    public Dojo findByDojoCode(String dojoCode){
        return dojoJpaPort.findByDojoCode(dojoCode)
                .orElseThrow(() -> new JMException(ErrorCode.DOJO_NOT_FOUND));
    }

    public DojoCoordinateDto findDojoCoordinate(Long dojoId){
        return dojoJpaPort.findDojoCoordinate(dojoId);
    }

    public Dojo findByUserId(Long userId){
        return dojoJpaPort.findByUserId(userId)
                .orElseThrow(() -> new JMException(ErrorCode.DOJO_NOT_FOUND));
    }
}
