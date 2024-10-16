package com.ghosttrio.judomanager.search.controller;

import com.ghosttrio.judomanager.search.document.Dojo;
import com.ghosttrio.judomanager.search.repository.DojoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final DojoRepository dojoRepository;

    public TestController(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    @PostMapping("/api/test")
    public String test() {
        Dojo dojo = Dojo.create();
        dojoRepository.save(dojo);
        return "test";
    }
}
