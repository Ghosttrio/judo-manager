package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "DojoClient", url = "http://localhost:8000/api/v1/dojos"
)
public interface DojoClient {

    @GetMapping("/{dojoCode}")
    Optional<Dojo> findDojoByDojoCode(@PathVariable String dojoCode);
}
