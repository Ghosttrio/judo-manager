package com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserRequest {
    private String id;
    private String nickname;
    private String email;
    private String profileImageUrl;
    private String phoneNumber;
    private String name;
}
