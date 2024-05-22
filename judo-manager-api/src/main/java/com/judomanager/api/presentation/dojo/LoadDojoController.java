package com.judomanager.api.presentation.dojo;

import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.dojo.service.LoadDojoService;
import com.judomanager.domain.user.domain.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dojos")
@Tag(name = "도장 조회 컨트롤러")
public class LoadDojoController {

    private final LoadDojoService loadDojoService;

    @Tag(name = "도장 생성 API")
    @Operation(summary = "각 도장에 등록되어 있는 회원을 모두 조회한다.")
    @GetMapping("/{dojoId}")
    public JMResponse<List<User>> loadDojoUser(@PathVariable Long dojoId){
        List<User> result = loadDojoService.findAllUserByDojoId(dojoId);
        return JMResponse.ok(result);
    }
}
