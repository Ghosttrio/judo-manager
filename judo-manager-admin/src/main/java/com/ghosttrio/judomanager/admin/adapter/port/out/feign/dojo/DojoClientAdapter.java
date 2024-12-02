package com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo;

import java.util.List;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.DojoState;
import org.springframework.stereotype.Component;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.Dojo;
import com.ghosttrio.judomanager.admin.application.port.out.DojoClientPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DojoClientAdapter implements DojoClientPort {

	private final DojoFeignClient dojoFeignClient;

	@Override
	public List<Dojo> findAll() {
		return dojoFeignClient.findAll();
	}

	@Override
	public void update(Long dojoId, DojoState state) {
		dojoFeignClient.update(dojoId, state);
	}
}
