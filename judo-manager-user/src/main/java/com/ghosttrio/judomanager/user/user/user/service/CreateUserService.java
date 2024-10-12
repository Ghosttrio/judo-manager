package com.ghosttrio.judomanager.user.user.user.service;

import com.ghosttrio.judomanager.user.user.user.domain.User;
import com.ghosttrio.judomanager.user.user.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateUserService {

    private final UserRepository userRepository;

    public User signup(String email){
        return userRepository.findByEmail(email)
                .orElseGet(() -> createUser(email));
    }

    private User createUser(String email){
        User user = User.init(email);
        return userRepository.save(user);
    }
}
