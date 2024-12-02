package com.ghosttrio.judomanager.search.adapter.port.in;

import com.ghosttrio.judomanager.search.adapter.port.in.model.request.CreateDojoIndexRequest;
import com.ghosttrio.judomanager.search.application.port.in.CreateDojoIndexUseCase;
import com.ghosttrio.judomanager.search.common.exception.JMResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/search")
public class CreateDojoIndexController {

    private final CreateDojoIndexUseCase createDojoIndexUseCase;

    @PostMapping("/dojos")
    public JMResponse<Void> createDojoIndex(@RequestBody CreateDojoIndexRequest request) {
        createDojoIndexUseCase.execute(request.dojoId(), request.name(), request.dojoCode(),
                request.price(), request.location(), request.latitude(), request.longitude());
        return JMResponse.ok();
    }
}
