package com.judomanager.domain.service.user;

import com.judomanager.common.common.exception.ErrorCode;
import com.judomanager.common.common.exception.JMException;
import com.judomanager.domain.domain.user.User;
import com.judomanager.domain.repository.user.UserRepository;
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
}
