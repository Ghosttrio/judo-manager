package com.ghosttrio.judomanager.user.mapper;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserEntity;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // todo 유저 도메인 수정 끝나면 한 번에 처리하기


    public UserDomain toDomain(UserEntity userEntity) {
//        return new UserDomain(
//                userEntity.getId(),
//                userEntity.getNickname(),
//                userEntity.getEmail(),
//                userEntity.getRole(),
//                userEntity.getState(),
//                userEntity.getLastLoginDate(),
//                userEntity.getCreatedAt(),
//                userEntity.getUpdatedAt(),
//                userEntity.getDojoId()
//        );
        return null;
    }

    public UserEntity toEntity(UserDomain userDomain) {
//        return new UserEntity(
//                userDomain.getId(),
//                userDomain.getNickname(),
//                userDomain.getRole(),
//                userDomain.getDojoId(),
//                userDomain.getEmail(),
//                userDomain.getLastLoginDate(),
//                userDomain.getState()
//        );
        return null;
    }
}
