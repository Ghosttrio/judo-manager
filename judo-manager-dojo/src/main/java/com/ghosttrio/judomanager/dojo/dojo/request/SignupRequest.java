package com.ghosttrio.judomanager.dojo.dojo.request;

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
