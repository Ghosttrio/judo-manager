package com.judomanager.api.controller.feign.pg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class AuthorizationService {

    @Value("${toss.key}")
    private String key;

    public String getAuthorization(){
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode((key + ":").getBytes(StandardCharsets.UTF_8));
        return  "Basic " + new String(encodedBytes);
    }
}