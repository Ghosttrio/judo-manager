package com.ghosttrio.judomanager.dojo.adapter.port.in;

import com.ghosttrio.judomanager.dojo.application.service.LoadDojoService;
import com.ghosttrio.judomanager.dojo.common.exception.JMResponse;
import com.ghosttrio.judomanager.dojo.domain.Dojo;
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
@Tag(name = "[Dojo API]")
public class LoadDojoController {

//    @Operation(summary = "각 도장에 등록되어 있는 회원을 모두 조회한다.")
//    @GetMapping("/{dojoId}")
//    public JMResponse<List<User>> loadDojoUser(@PathVariable Long dojoId){
//        List<User> result = loadDojoService.findAllUserByDojoId(dojoId);
//        return JMResponse.ok(result);
//    }

//    @Operation(summary = "로그인한 회원이 속한 도장의 정보를 조회한다.")
//    @GetMapping("/{userId}")
//    public JMResponse<Dojo> loadDojoByUserId(@PathVariable Long userId){
//        Dojo result = loadDojoService.findByUserId(userId);
//        return JMResponse.ok(result);
//    }

    @GetMapping("/{dojoCode}")
    public JMResponse<Dojo> loadDojoByDojoCode(@PathVariable String dojoCode) {
        return JMResponse.ok(null);
    }
}
