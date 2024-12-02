package com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo;

import java.util.List;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.DojoState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.Dojo;

@FeignClient(
	name = "DojoFeignClient", url = "http://localhost:8080/api/v1/dojos"
)
public interface DojoFeignClient {

	@GetMapping
	List<Dojo> findAll();

	@PatchMapping("/status")
	void update(@RequestParam Long dojoId,
				@RequestParam DojoState state);
}
