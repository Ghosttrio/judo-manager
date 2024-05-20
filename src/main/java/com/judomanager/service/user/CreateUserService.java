package com.judomanager.service.user;

import com.judomanager.domain.user.User;
import com.judomanager.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateUserService {

    private final UserRepository userRepository;

    @Transactional
    public User signup(String email){
        return userRepository.findByEmail(email)
                .orElseGet(() -> createUser(email));
    }

    private User createUser(String email){
        User user = User.init(email);
        return userRepository.save(user);
    }
}
