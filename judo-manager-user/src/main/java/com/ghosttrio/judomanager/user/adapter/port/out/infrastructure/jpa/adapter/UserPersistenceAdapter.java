package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.adapter;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserEntity;
import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.repository.UserRepository;
import com.ghosttrio.judomanager.user.application.port.out.UserPersistencePort;
import com.ghosttrio.judomanager.user.common.exception.JMException;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import com.ghosttrio.judomanager.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.ghosttrio.judomanager.user.common.exception.ErrorCode.USER_NOT_FOUND;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void save(UserDomain userDomain) {
        UserEntity userEntity = userMapper.toEntity(userDomain);
        userRepository.save(userEntity);
    }

    @Override
    public UserDomain findById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new JMException(USER_NOT_FOUND));
        return userMapper.toDomain(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDomain findByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new JMException(USER_NOT_FOUND));
        return userMapper.toDomain(userEntity);
    }

    @Override
    public boolean isDuplicateUser(String email) {
        Optional<UserEntity> userEntity = userRepository.findByEmail(email);
        return userEntity.isPresent();
    }

    @Override
    public boolean isDuplicateNickname(String nickname) {
        Optional<UserEntity> userEntity = userRepository.findByNickname(nickname);
        return userEntity.isPresent();
    }
}
