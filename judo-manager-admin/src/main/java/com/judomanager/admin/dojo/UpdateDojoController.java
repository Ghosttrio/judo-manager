package com.judomanager.admin.dojo;

import com.judomanager.admin.dojo.request.UpdateDojoRequest;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.dojo.service.UpdateDojoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/v1/dojos")
@Tag(name = "관리자 도장 API")
public class UpdateDojoController {

    private final UpdateDojoService updateDojoService;
    
    @Operation(summary = "요청한 도장을 승인/거절 한다.")
    @PatchMapping("/{dojoId}/state")
    public JMResponse<Void> updateDojoState(@PathVariable Long dojoId,
                                            @RequestBody UpdateDojoRequest request){
        updateDojoService.updateState(dojoId, request.state());
        return JMResponse.ok();
    }

}
