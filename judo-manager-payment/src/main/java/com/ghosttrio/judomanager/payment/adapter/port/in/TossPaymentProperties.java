package com.ghosttrio.judomanager.payment.adapter.port.in;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "tosspayments")
public class TossPaymentProperties {
    private String secret_key;
}
