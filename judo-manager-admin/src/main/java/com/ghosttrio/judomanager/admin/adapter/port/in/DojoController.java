package com.ghosttrio.judomanager.admin.adapter.port.in;

import com.ghosttrio.judomanager.admin.adapter.port.in.model.UpdateDojoRequest;
import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.Dojo;
import com.ghosttrio.judomanager.admin.application.port.in.dojo.LoadDojoUseCase;
import com.ghosttrio.judomanager.admin.application.port.in.dojo.UpdateDojoUseCase;
import com.ghosttrio.judomanager.admin.config.exception.JMResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admins/dojos")
@Tag(name = "[ADMIN API]")
public class DojoController {

    private final UpdateDojoUseCase updateDojoUseCase;
    private final LoadDojoUseCase loadDojoUseCase;

    @Operation(summary = "유도 매니저에 등록된 모든 도장을 조회한다.")
    @GetMapping
    public JMResponse<List<Dojo>> loadAllDojo() {
        List<Dojo> result = loadDojoUseCase.execute();
        return JMResponse.ok(result);
    }

    @Operation(summary = "등록 요청한 도장을 승인/거절 한다.")
    @PatchMapping("/{dojoId}/state")
    public JMResponse<Void> approvalDojo(@PathVariable Long dojoId,
                                         @RequestBody UpdateDojoRequest request) {
        updateDojoUseCase.execute(dojoId, request.state());
        return JMResponse.ok();
    }
}
