package com.judomanager.api.presentation.dojo.model.request;

public class SignupRequest {

    public record Dojo(
            Long dojoId,
            Long userId
    ){}

    public record Nickname(
            String nickname,
            Long userId
    ){}
}
