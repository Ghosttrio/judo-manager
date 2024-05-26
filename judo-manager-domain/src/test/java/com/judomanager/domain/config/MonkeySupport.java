package com.judomanager.domain.config;

import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.api.introspector.ConstructorPropertiesArbitraryIntrospector;
import com.navercorp.fixturemonkey.api.introspector.FailoverIntrospector;
import com.navercorp.fixturemonkey.api.introspector.FieldReflectionArbitraryIntrospector;
import com.navercorp.fixturemonkey.jakarta.validation.plugin.JakartaValidationPlugin;

import java.util.List;

public abstract class MonkeySupport {

	protected final FixtureMonkey monkey = FixtureMonkey.builder()
		.objectIntrospector(new FailoverIntrospector(
			List.of(
				ConstructorPropertiesArbitraryIntrospector.INSTANCE,
				FieldReflectionArbitraryIntrospector.INSTANCE
			)
		))
		.plugin(new JakartaValidationPlugin())
		.defaultNotNull(true)
		.build();
}
