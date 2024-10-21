package com.ghosttrio.judomanager.user.application.service;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.UserRepository;
import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserEntity;
import com.ghosttrio.judomanager.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateUserService {

    private final UserRepository userRepository;

    @Transactional
    public UserEntity signup(String email){
        /**
         * 닉네임 중복 체크
         * 이메일 중복 체크
         */


        return userRepository.findByEmail(email)
                .orElseGet(() -> createUser(email));
    }

    private UserEntity createUser(String email){
        UserEntity userEntity = User.init(email);
        return userRepository.save(userEntity);
    }
}
