package com.judomanager.service.user;

import com.judomanager.domain.user.User;
import com.judomanager.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadUserService {

    private final UserRepository userRepository;

    public List<User> findAllUserByDojoId(Long dojoId){
        return userRepository.findAllUserByDojoId(dojoId);
    }
}
