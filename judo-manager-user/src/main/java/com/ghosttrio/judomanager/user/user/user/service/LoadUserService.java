package com.ghosttrio.judomanager.user.user.user.service;

import com.ghosttrio.judomanager.user.user.user.domain.User;
import com.ghosttrio.judomanager.user.user.user.repository.UserRepository;
import com.judomanager.common.exception.ErrorCode;
import com.judomanager.common.exception.JMException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadUserService {

    private final UserRepository userRepository;

    public User findById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new JMException(ErrorCode.USER_NOT_FOUND));
    }

    public List<User> findAllUserByDojoId(Long dojoId){
        return userRepository.findAllUserByDojoId(dojoId);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
