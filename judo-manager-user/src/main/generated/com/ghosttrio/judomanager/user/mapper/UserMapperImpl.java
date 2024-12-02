package com.ghosttrio.judomanager.user.mapper;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserEntity;
import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserRole;
import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserState;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-14T13:55:00+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.0.jar, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDomain toUserDomain(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        Long id = null;
        String nickname = null;
        UserRole role = null;
        Long dojoId = null;
        String email = null;
        LocalDateTime lastLoginDate = null;
        UserState state = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        id = userEntity.getId();
        nickname = userEntity.getNickname();
        role = userEntity.getRole();
        dojoId = userEntity.getDojoId();
        email = userEntity.getEmail();
        lastLoginDate = userEntity.getLastLoginDate();
        state = userEntity.getState();
        createdAt = userEntity.getCreatedAt();
        updatedAt = userEntity.getUpdatedAt();

        UserDomain userDomain = new UserDomain( id, nickname, email, role, state, lastLoginDate, createdAt, updatedAt, dojoId );

        return userDomain;
    }

    @Override
    public UserEntity toUserEntity(UserDomain userDomainEntity) {
        if ( userDomainEntity == null ) {
            return null;
        }

        Long id = null;
        String nickname = null;
        UserRole role = null;
        Long dojoId = null;
        String email = null;
        LocalDateTime lastLoginDate = null;
        UserState state = null;

        id = userDomainEntity.getId();
        nickname = userDomainEntity.getNickname();
        role = userDomainEntity.getRole();
        dojoId = userDomainEntity.getDojoId();
        email = userDomainEntity.getEmail();
        lastLoginDate = userDomainEntity.getLastLoginDate();
        state = userDomainEntity.getState();

        UserEntity userEntity1 = new UserEntity( id, nickname, role, dojoId, email, lastLoginDate, state );

        return userEntity1;
    }
}
