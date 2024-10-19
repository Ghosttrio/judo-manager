package com.ghosttrio.judomanager.user.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "openapi")
public class OpenApiProperties {

    private String service_key;
    private String base_uri;

}
