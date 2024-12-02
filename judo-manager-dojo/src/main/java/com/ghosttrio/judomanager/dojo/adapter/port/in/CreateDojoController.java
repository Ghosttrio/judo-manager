package com.ghosttrio.judomanager.dojo.adapter.port.in;

import com.ghosttrio.judomanager.dojo.adapter.port.in.request.CreateDojoRequest;
import com.ghosttrio.judomanager.dojo.application.port.in.CreateAllDojoUseCase;
import com.ghosttrio.judomanager.dojo.application.port.in.CreateDojoUseCase;
import com.ghosttrio.judomanager.dojo.common.exception.JMResponse;
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

    private final CreateDojoUseCase createDojoUseCase;
    private final CreateAllDojoUseCase createAllDojoUseCase;

    @Operation(summary = "관장님이 나의 도장을 생성한다.")
    @PostMapping
    public JMResponse<Void> creatDojo(@RequestBody CreateDojoRequest request){
        createDojoUseCase.execute(
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
        createAllDojoUseCase.execute();
        return JMResponse.ok();
    }

}
