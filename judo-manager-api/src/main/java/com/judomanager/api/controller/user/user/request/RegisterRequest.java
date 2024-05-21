package com.judomanager.api.controller.user.user.request;

public class RegisterRequest {

    public record Nickname(String nickname){}

    public record Dojo(String dojoCode){}
}
