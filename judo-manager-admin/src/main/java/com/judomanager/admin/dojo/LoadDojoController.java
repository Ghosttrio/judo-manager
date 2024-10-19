//package com.judomanager.admin.dojo;
//
//import com.judomanager.common.exception.JMResponse;
//import com.judomanager.domain.dojo.domain.Dojo;
//import com.judomanager.domain.dojo.service.LoadDojoService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/admin/v1/dojos")
//@Tag(name = "관리자 도장 조회 컨트롤러")
//public class LoadDojoController {
//
//    private final LoadDojoService loadDojoService;
//
//    @Tag(name = "관리자 도장 전체 조회 API")
//    @Operation(summary = "유도 매니저에 등록된 모든 도장을 조회한다.")
//    @GetMapping
//    public JMResponse<List<Dojo>> loadAllDojo(){
//        List<Dojo> result = loadDojoService.findAll();
//        return JMResponse.ok(result);
//    }
//
//}
