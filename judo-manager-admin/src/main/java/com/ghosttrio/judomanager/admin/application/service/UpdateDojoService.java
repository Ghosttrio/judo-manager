package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.DojoState;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghosttrio.judomanager.admin.application.port.out.DojoClientPort;

import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UpdateDojoService {

	private final DojoClientPort dojoClientPort;
	private final CircuitBreakerFactory circuitBreakerFactory;

	public void executeUpdate(Long dojoId, DojoState state) {
		dojoClientPort.update(dojoId, state);
	}

	@Transactional
	public void update(Long dojoId, DojoState state) {
		CircuitBreaker cb = circuitBreakerFactory.create("dojoCB");
		Supplier<Void> deleteAction = () -> {
			executeUpdate(dojoId, state);
			return null;
		};
		cb.run(deleteAction);
	}

}
