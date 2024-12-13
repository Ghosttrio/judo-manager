package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.feign.client;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.feign.model.Dojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "DojoClient", url = "http://localhost:54694/api/v1/dojos")
public interface DojoClient {
    @GetMapping("/{dojoCode}")
    Dojo findDojoByDojoCode(@PathVariable String dojoCode);
}
