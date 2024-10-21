package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserEntity;
import com.ghosttrio.judomanager.user.application.port.out.UserPort;
import com.ghosttrio.judomanager.user.common.exception.ErrorCode;
import com.ghosttrio.judomanager.user.common.exception.JMException;
import com.ghosttrio.judomanager.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserPort {

    private final UserRepository userRepository;

    @Override
    public void save() {
        userRepository.save(null);
    }

    @Override
    public User findById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new JMException(ErrorCode.USER_NOT_FOUND));
        return userEntity.toUserDomain();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
