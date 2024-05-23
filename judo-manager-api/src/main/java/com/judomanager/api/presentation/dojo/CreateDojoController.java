package com.judomanager.api.presentation.dojo;

import com.judomanager.api.presentation.dojo.request.CreateDojoRequest;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.dojo.service.CreateDojoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dojos")
@Tag(name = "[Dojo API]")
public class CreateDojoController {

    private final CreateDojoService createDojoService;

    @Operation(summary = "관장님이 나의 도장을 생성한다.")
    @PostMapping
    public JMResponse<Void> creatDojo(@RequestBody CreateDojoRequest request){
        createDojoService.createDojo(
                request.masterId(),
                request.name(),
                request.location(),
                request.phone(),
                request.latitude(),
                request.longitude(),
                request.radius());
        return JMResponse.ok();
    }

    @Operation(summary = "Open API를 이용하여 전국 도장 리스트를 저장한다.")
    @PostMapping("/database/dojo")
    public JMResponse<Void> createAllDojo() {
        createDojoService.createAllDojo();
        return JMResponse.ok();
    }

}
