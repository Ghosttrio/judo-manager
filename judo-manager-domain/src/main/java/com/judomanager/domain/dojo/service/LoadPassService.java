package com.judomanager.domain.dojo.service;

import com.judomanager.common.exception.ErrorCode;
import com.judomanager.common.exception.JMException;
import com.judomanager.domain.dojo.domain.Pass;
import com.judomanager.domain.dojo.repository.pass.PassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.judomanager.common.exception.ErrorCode.PASS_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadPassService {

    private final PassRepository passRepository;


    public Pass loadLessonByUserId(Long userId){
        return passRepository.findByUserPass(userId)
                .orElseThrow(() -> new JMException(PASS_NOT_FOUND));
    }


}
