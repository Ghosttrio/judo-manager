package com.judomanager.admin.user;

import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.user.domain.User;
import com.judomanager.domain.user.service.LoadUserService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/admin/v1/users")
@Tag(name = "관리자 회원 조회 컨트롤러")
public class LoadUserController {

    private final LoadUserService loadUserService;

    @Tag(name = "관리자 회원 전체 조회 API")
    @Operation(summary = "유도 매니저에 등록된 모든 회원을 조회한다.")
    @GetMapping
    public JMResponse<List<User>> loadAllUser(){
        List<User> result = loadUserService.findAll();
        return JMResponse.ok(result);
    }
}
