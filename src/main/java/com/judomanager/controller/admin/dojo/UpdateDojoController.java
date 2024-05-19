package com.judomanager.controller.admin.dojo;

import com.judomanager.common.JMResponse;
import com.judomanager.dto.dojo.UpdateDojoRequest;
import com.judomanager.service.dojo.UpdateDojoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dojos")
@Tag(name = "관리자 도장 수정 컨트롤러")
public class UpdateDojoController {

    private final UpdateDojoService updateDojoService;

    @PatchMapping("/{dojoId}/state")
    public JMResponse<Void> updateDojoState(@PathVariable Long dojoId,
                                            @RequestBody UpdateDojoRequest request){
        updateDojoService.updateState(dojoId, request.state());
        return JMResponse.ok();
    }
}
