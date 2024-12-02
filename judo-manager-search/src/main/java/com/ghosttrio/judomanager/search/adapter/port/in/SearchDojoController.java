package com.ghosttrio.judomanager.search.adapter.port.in;

import com.ghosttrio.judomanager.search.adapter.port.out.elasticsearch.document.Dojo;
import com.ghosttrio.judomanager.search.application.port.in.SearchDojoUseCase;
import com.ghosttrio.judomanager.search.application.port.in.SearchNearDojoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/search")
public class SearchDojoController {

    private final SearchDojoUseCase searchDojoUseCase;
    private final SearchNearDojoUseCase searchNearDojoUseCase;

    @GetMapping("/dojos")
    public List<Dojo> searchDojo(@RequestParam(required = false) String name,
                                 @RequestParam(required = false) String location,
                                 @RequestParam(required = false) Double latitude,
                                 @RequestParam(required = false) Double longitude) {
        return searchDojoUseCase.execute(name, location, latitude, longitude);
    }

    @GetMapping("/dojos/near")
    public List<Dojo> searchNearDojo(@RequestParam Double latitude,
                                     @RequestParam Double longitude) {
        return searchNearDojoUseCase.execute(latitude, longitude);
    }
}
