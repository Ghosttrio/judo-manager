package com.ghosttrio.judomanager.user.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "kakao")
public class KakaoProperties {
    private String grant_type;
    private String client_id;
    private String client_secret;
    private String redirect_uri;
}
