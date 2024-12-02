package com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.request;

import lombok.Data;

@Data
public class KakaoTokenRequest {
    private String grant_type;
    private String client_id;
    private String redirect_uri;
    private String code;
    private String client_secret;
}
