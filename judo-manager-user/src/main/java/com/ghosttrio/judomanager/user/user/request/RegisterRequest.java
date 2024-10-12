package com.ghosttrio.judomanager.user.user.request;

public class RegisterRequest {

    public record Nickname(String nickname){}

    public record Dojo(String dojoCode){}
}
