package com.ghosttrio.judomanager.user.application.service;

import com.ghosttrio.judomanager.user.application.port.in.LoadUserUseCase;
import com.ghosttrio.judomanager.user.application.port.out.UserPort;
import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserEntity;
import com.ghosttrio.judomanager.user.common.exception.ErrorCode;
import com.ghosttrio.judomanager.user.common.exception.JMException;
import com.ghosttrio.judomanager.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadUserService {

    private final UserPort userPort;

    public User findById(Long userId){
        return userPort.findById(userId);
    }

//    public List<User> findAllUserByDojoId(Long dojoId){
//        return userRepository.findAllUserByDojoId(dojoId);
//    }
//
//    public List<User> findAll(){
//        return userRepository.findAll();
//    }
}
