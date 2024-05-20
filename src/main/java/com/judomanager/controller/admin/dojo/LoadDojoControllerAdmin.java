package com.judomanager.controller.admin.dojo;

import com.judomanager.common.JMResponse;
import com.judomanager.domain.dojo.Dojo;
import com.judomanager.service.dojo.LoadDojoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dojos")
@Tag(name = "관리자 도장 조회 컨트롤러")
public class LoadDojoControllerAdmin {

    private final LoadDojoService loadDojoService;

    @GetMapping
    public JMResponse<List<Dojo>> loadAllDojo(){
        List<Dojo> result = loadDojoService.findAll();
        return JMResponse.ok(result);
    }

}
