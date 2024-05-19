package com.judomanager.controller.user.dojo;

import com.judomanager.common.JMResponse;
import com.judomanager.dto.dojo.CreateDojoRequest;
import com.judomanager.service.dojo.CreateDojoService;
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
@Tag(name = "도장 생성 컨트롤러")
public class CreateDojoController {

    private final CreateDojoService createDojoService;

    // 도장 생성 요청
    @PostMapping
    public JMResponse<Void> creatDojo(@RequestBody CreateDojoRequest request){
        createDojoService.createDojo(request.masterId(), request.name(), request.location());
        return JMResponse.ok();
    }

}
