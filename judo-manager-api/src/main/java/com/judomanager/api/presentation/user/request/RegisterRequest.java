package com.judomanager.api.presentation.user.request;

public class RegisterRequest {

    public record Nickname(String nickname){}

    public record Dojo(String dojoCode){}
}
