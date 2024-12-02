package com.ghosttrio.judomanager.batch.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "slack")
public class SlackProperties {
	private String token;
	private String channel;
}
