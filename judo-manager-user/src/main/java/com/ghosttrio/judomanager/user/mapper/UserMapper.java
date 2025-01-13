package com.ghosttrio.judomanager.user.mapper;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserEntity;
import com.ghosttrio.judomanager.user.domain.UserAddress;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import com.ghosttrio.judomanager.user.domain.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDomain toDomain(UserEntity userEntity) {
        UserAddress userAddress = UserAddress.createUserAddress(
                userEntity.getLocation(),
                userEntity.getLatitude(),
                userEntity.getLongitude());

        UserProfile userProfile = UserProfile.createUserProfile(userEntity.getNickname(),
                userEntity.getEmail(),
                userEntity.getRole(),
                userAddress);

        return new UserDomain(
                userEntity.getId(),
                userProfile,
                userEntity.getState(),
                userEntity.getLastLoginDate(),
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt(),
                userEntity.getDojoId(),
                userEntity.getBelt(),
                userEntity.getGrade());
    }

    public UserEntity toEntity(UserDomain userDomain) {
        return new UserEntity(
                userDomain.getId(),
                userDomain.getUserProfile().getNickname(),
                userDomain.getUserProfile().getRole(),
                userDomain.getUserProfile().getEmail(),
                userDomain.getState(),
                userDomain.getLastLoginDate(),
                userDomain.getDojoId(),
                userDomain.getBelt(),
                userDomain.getGrade(),
                userDomain.getUserProfile().getUserAddress().getLocation(),
                userDomain.getUserProfile().getUserAddress().getLatitude(),
                userDomain.getUserProfile().getUserAddress().getLongitude()
        );
    }
}
