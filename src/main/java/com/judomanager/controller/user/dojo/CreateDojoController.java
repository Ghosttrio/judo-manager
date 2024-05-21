package com.judomanager.controller.user.dojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.judomanager.common.JMResponse;
import com.judomanager.dto.dojo.CreateDojoRequest;
import com.judomanager.repository.dojo.DojoRepository;
import com.judomanager.service.dojo.CreateDojoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dojos")
@Tag(name = "도장 생성 컨트롤러")
public class CreateDojoController {

    private final CreateDojoService createDojoService;

    @Tag(name = "도장 생성 API")
    @Operation(summary = "관장님이 나의 도장을 생성한다.")
    @PostMapping
    public JMResponse<Void> creatDojo(@RequestBody CreateDojoRequest request){
        createDojoService.createDojo(request.masterId(), request.name(), request.location(), request.phone());
        return JMResponse.ok();
    }

    @Tag(name = "도장 DB 생성 API")
    @Operation(summary = "Open API를 이용하여 전국 도장 리스트를 저장한다.")
    @PostMapping("/database/dojo")
    public JMResponse<Void> createAllDojo() {
        createDojoService.createAllDojo();
        return JMResponse.ok();
    }

}
