package com.ghosttrio.judomanager.dojo.adapter.port.in;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.DojoState;
import com.ghosttrio.judomanager.dojo.application.port.in.UpdateDojoStatusUseCase;
import com.ghosttrio.judomanager.dojo.common.exception.JMResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dojos")
@Tag(name = "[Dojo API]")
public class UpdateDojoController {

    private final UpdateDojoStatusUseCase updateDojoStatusUseCase;

    @PatchMapping("/status")
    public JMResponse<Void> updateDojoStatus(@RequestParam Long dojoId,
                                             @RequestParam DojoState state) {
        updateDojoStatusUseCase.execute(dojoId, state);
    }
}
