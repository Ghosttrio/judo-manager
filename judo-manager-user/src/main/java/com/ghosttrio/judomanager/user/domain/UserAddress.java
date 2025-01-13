package com.ghosttrio.judomanager.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAddress {
    private String location;
    private Double latitude;
    private Double longitude;

    public static UserAddress createUserAddress(String location, Double latitude, Double longitude) {
        return new UserAddress(location, latitude, longitude);
    }
}
