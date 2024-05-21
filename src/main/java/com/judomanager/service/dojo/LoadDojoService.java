package com.judomanager.service.dojo;

import com.judomanager.common.exception.ErrorCode;
import com.judomanager.common.exception.JMException;
import com.judomanager.domain.dojo.Dojo;
import com.judomanager.domain.user.User;
import com.judomanager.repository.dojo.DojoRepository;
import com.judomanager.service.user.LoadUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.judomanager.common.exception.ErrorCode.DOJO_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadDojoService {

    private final DojoRepository dojoRepository;
    private final LoadUserService loadUserService;

    public void checkDojoExist(Long dojoId){
        dojoRepository.findById(dojoId).orElseThrow(() -> new JMException(DOJO_NOT_FOUND));
    }

    public List<Dojo> findAll(){
        return dojoRepository.findAll();
    }

    public List<User> findAllUserByDojoId(Long dojoId){
        return loadUserService.findAllUserByDojoId(dojoId);
    }

    public Dojo findByDojoCode(String dojoCode){
        return dojoRepository.findByDojoCode(dojoCode)
                .orElseThrow(() -> new JMException(DOJO_NOT_FOUND));
    }
}
